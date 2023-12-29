package com.snow.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.snow.horoscapp.domain.model.PredictionModel

data class PredictionResponse (
    @SerializedName("date") val date:String,
    @SerializedName("horoscope") val prediction:String,
    @SerializedName("sign") val sign:String,
){
    fun toDomain():PredictionModel {
        return PredictionModel(prediction= prediction, sign = sign)
    }
}