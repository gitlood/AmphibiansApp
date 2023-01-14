package com.example.android.amphibiansapp.data.repository.interfaces

import com.example.android.amphibiansapp.data.response.Amphibian
import com.example.android.amphibiansapp.data.util.Resource

interface AmphibianRepository {
    suspend fun fetchAmphibianData(): Resource<List<Amphibian>>
}
