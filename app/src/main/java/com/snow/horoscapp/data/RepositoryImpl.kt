package com.snow.horoscapp.data

import android.util.Log
import com.snow.horoscapp.data.network.HoroscopeApiService
import com.snow.horoscapp.domain.Repository
import com.snow.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService:HoroscopeApiService):Repository{
    override suspend fun getPrediction(sign: String): PredictionModel? {
        // Peticion Retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Horoscope Error", "Ha ocurrido un error ${it.message}") }
        return null
    }
}