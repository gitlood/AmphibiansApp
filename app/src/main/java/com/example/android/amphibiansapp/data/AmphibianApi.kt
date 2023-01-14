package com.example.android.amphibiansapp.data

import com.google.gson.JsonObject
import retrofit2.http.GET

interface AmphibianApi {

    @GET
    suspend fun fetchAmphibianData(): JsonObject
}
