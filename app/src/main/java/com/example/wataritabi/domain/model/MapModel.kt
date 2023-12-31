package com.example.wataritabi.domain.model

import com.google.android.gms.maps.model.LatLng

data class MapModel(
    var placeId: MutableList<String> = mutableListOf(),
    var primaryText: MutableList<String> = mutableListOf(),
    var location: MutableList<LatLng> = mutableListOf(),
)