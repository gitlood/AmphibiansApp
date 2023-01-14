package com.example.android.amphibiansapp.data

import com.google.gson.JsonArray
import retrofit2.http.GET

interface AmphibianApi {

    @GET("amphibians")
    suspend fun fetchAmphibianData(): JsonArray
}
