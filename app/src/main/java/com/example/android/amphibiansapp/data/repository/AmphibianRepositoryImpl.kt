package com.example.android.amphibiansapp.data.repository

import com.example.android.amphibiansapp.data.AmphibianApi
import com.example.android.amphibiansapp.data.repository.interfaces.AmphibianRepository
import javax.inject.Inject

class AmphibianRepositoryImpl @Inject constructor(
    private val amphibianApi: AmphibianApi
) :
    AmphibianRepository {
    override suspend fun fetchAmphibianData() {
        amphibianApi.fetchAmphibianData()
    }
}
