package com.example.wataritabi.model

import com.google.android.gms.maps.model.LatLng

data class MapModel(
    val currentAddress: String = "",
    var location: MutableList<LatLng> = mutableListOf(),
)