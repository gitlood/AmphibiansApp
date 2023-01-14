package com.example.android.amphibiansapp.di

import com.example.android.amphibiansapp.data.AmphibianApi
import com.example.android.amphibiansapp.data.util.BASE_URL
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class AppModule {

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
}
