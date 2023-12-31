package com.example.wataritabi.ui.viewmodel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wataritabi.domain.model.MapModel
import com.example.wataritabi.domain.model.PhotoModel
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.PlaceTypes
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MapViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MapModel())
    val uiState: StateFlow<MapModel> = _uiState.asStateFlow()

    fun addDestination(destination: AutocompleteResult) {
        _uiState.value.placeId.add(destination.placeId)
        _uiState.value.primaryText.add(destination.primaryText)
    }

    fun getLocation(result: AutocompleteResult, placesClient: PlacesClient) {
        val placeFields = listOf(Place.Field.LAT_LNG)
        val request = FetchPlaceRequest.newInstance(result.placeId, placeFields)
        placesClient.fetchPlace(request)
            .addOnSuccessListener {
                val place = it.place
                _uiState.value.location.add(place.latLng!!)
            }
    }

    data class AutocompleteResult(
        val placeId: String,
        val primaryText: String,
    )

    val locationAutofill = mutableStateListOf<AutocompleteResult>()
    private val token = AutocompleteSessionToken.newInstance()
    private val bounds = RectangularBounds.newInstance(
        LatLng(20.0, 122.0),
        LatLng(46.0, 154.0)
    )
    var currentLatLong by mutableStateOf(LatLng(0.0, 0.0))

    private var job: Job? = null
    fun searchPlaces(query: String, placesClient: PlacesClient) {
        job?.cancel()
        locationAutofill.clear()
        job = viewModelScope.launch {
            val request = FindAutocompletePredictionsRequest.builder()
                .setLocationBias(bounds)
                .setOrigin(LatLng(36.0, 140.0))
                .setCountries("jp")
                .setTypesFilter(listOf(PlaceTypes.ESTABLISHMENT))
                .setSessionToken(token)
                .setQuery(query)
                .build()
            placesClient.findAutocompletePredictions(request)
                .addOnSuccessListener { response ->
                    locationAutofill += response.autocompletePredictions.map {
                        AutocompleteResult(
                            placeId = it.placeId,
                            primaryText = it.getPrimaryText(null).toString()
                        )
                    }
                }.addOnFailureListener { exception ->
                    if (exception is ApiException) {
                        Log.e(ContentValues.TAG, "Place not found: ${exception.statusCode}")
                    }
                }
        }
    }


    val photoUiState = mutableStateOf(PhotoModel())

    fun getPlacePhoto(placesClient: PlacesClient) {
        val samplePlaceId = _uiState.value.placeId[0]
        val fields = listOf(Place.Field.PHOTO_METADATAS)
        val placeRequest = FetchPlaceRequest.newInstance(samplePlaceId, fields)

        placesClient.fetchPlace(placeRequest)
            .addOnSuccessListener { response ->
                val place = response.place
                val metadata = place.photoMetadatas
                if (metadata == null || metadata.isEmpty()) {
                    Log.w(TAG, "No photo metadata.")
                    return@addOnSuccessListener
                }
                val photoMetadata = metadata.first()
                val attributions = photoMetadata?.attributions
                val photoRequest = FetchPhotoRequest.builder(photoMetadata)
                    .setMaxWidth(500)
                    .setMaxHeight(300)
                    .build()
                placesClient.fetchPhoto(photoRequest)
                    .addOnSuccessListener { fetchPhotoResponse ->
                        val bitmap = fetchPhotoResponse.bitmap
                        photoUiState.value.photoBitmap = bitmap
                    }.addOnFailureListener { exception ->
                        if (exception is ApiException) {
                            Log.e(ContentValues.TAG, "Place not found: ${exception.statusCode}")
                        }
                    }
            }
    }

}