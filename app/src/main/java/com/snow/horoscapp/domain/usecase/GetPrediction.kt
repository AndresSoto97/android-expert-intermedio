package com.snow.horoscapp.domain.usecase

import com.snow.horoscapp.domain.Repository
import com.snow.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)
}