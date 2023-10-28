package com.example.wataritabi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wataritabi.model.MapModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MapViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MapModel())
    val uiState: StateFlow<MapModel> = _uiState.asStateFlow()

    init {
        _uiState.value = MapModel("", 35.6809591, 139.7673068)
    }

    fun addDestination(destination: MapModel) {
        _uiState.value = destination
    }
//    var uiState by mutableStateOf(MapUiState())
//        private set
//
//    fun addDestination(destination: MapUiState) {
//        uiState = destination
//    }
}