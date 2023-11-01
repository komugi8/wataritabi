package com.example.wataritabi.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wataritabi.model.MapModel
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.PlaceTypes
import com.google.android.libraries.places.api.model.RectangularBounds
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

    fun addDestination(destination: LatLng) {
        _uiState.value.location.add(destination)
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
//                    for (prediction in response.autocompletePredictions) {
//                        Log.i(ContentValues.TAG, prediction.placeId)
//                        Log.i(ContentValues.TAG, prediction.getPrimaryText(null).toString())
//                    }
                }.addOnFailureListener { exception ->
                    if (exception is ApiException) {
                        Log.e(ContentValues.TAG, "Place not found: ${exception.statusCode}")
                    }
                }
        }
    }
}