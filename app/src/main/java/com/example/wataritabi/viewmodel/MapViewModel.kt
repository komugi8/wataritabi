package com.example.wataritabi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wataritabi.model.MapModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MapViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MapModel())
    val uiState: StateFlow<MapModel> = _uiState.asStateFlow()

    fun addDestination(destination: LatLng) {
        _uiState.value.location.add(destination)
    }
//    var uiState by mutableStateOf(MapUiState())
//        private set
//
//    fun addDestination(destination: MapUiState) {
//        uiState = destination
//    }
}