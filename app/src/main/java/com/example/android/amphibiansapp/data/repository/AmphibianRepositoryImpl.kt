package com.example.android.amphibiansapp.data.repository

import com.example.android.amphibiansapp.data.AmphibianApi
import com.example.android.amphibiansapp.data.repository.interfaces.AmphibianRepository
import com.example.android.amphibiansapp.data.response.Amphibian
import com.example.android.amphibiansapp.data.util.*
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class AmphibianRepositoryImpl @Inject constructor(
    private val amphibianApi: AmphibianApi
) :
    AmphibianRepository {
    override suspend fun fetchAmphibianData(): Resource<List<Amphibian>> {
        return try {
            withContext(Dispatchers.IO) {
                val amphibians = mutableListOf<Amphibian>()
                amphibianApi.fetchAmphibianData().forEach {
                    amphibians.add(setListingToListingData(it.asJsonObject))
                }
                Resource.Success(amphibians)
            }
        } catch (e: HttpException) {
            Resource.Error(e.toString())
        }
    }


    private fun setListingToListingData(amphibian: JsonObject): Amphibian {
        return Amphibian(
            name = amphibian.get(NAME).asString,
            type = amphibian.get(TYPE).asString,
            description = amphibian.get(DESCRIPTION).asString,
            imgsrc = amphibian.get(IMG_SRC).asString
        )
    }
}
