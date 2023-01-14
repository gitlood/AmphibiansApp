package com.example.android.amphibiansapp.di

import com.example.android.amphibiansapp.data.AmphibianApi
import com.example.android.amphibiansapp.data.repository.AmphibianRepositoryImpl
import com.example.android.amphibiansapp.data.repository.interfaces.AmphibianRepository
import com.example.android.amphibiansapp.data.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): AmphibianApi =
        retrofit.create(AmphibianApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideRepository(api: AmphibianApi): AmphibianRepository =
        AmphibianRepositoryImpl(api)
}
