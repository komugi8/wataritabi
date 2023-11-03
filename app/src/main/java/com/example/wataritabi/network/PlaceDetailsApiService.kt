package com.example.wataritabi.network

//import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
//import retrofit2.http.GET
//
//private const val BASE_URL = "https://maps.googleapis.com/v1/places/{placeId}?key={API_KEY}"
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()
//
//interface PlaceDetailsApiService {
//    @GET("details")
//    suspend fun getPlaceDetails(): String
//}
//
//object PlaceDetailsApi {
//    val retrofitService: PlaceDetailsApiService by lazy {
//        retrofit.create(PlaceDetailsApiService::class.java)
//    }
//}