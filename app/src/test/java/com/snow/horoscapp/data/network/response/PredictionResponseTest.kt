package com.snow.horoscapp.data.network.response

import com.snow.horoscapp.motherobject.PredictionMotherObject
import com.snow.horoscapp.motherobject.PredictionMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*


class PredictionResponseTest{

    @Test
    fun `toDomain should return a correct PredictionModel`(){
        // Given
        val predictionResponse = anyResponse

        // When
        val predictionModel = predictionResponse.toDomain()
        // Then
        predictionModel.sign shouldBe predictionResponse.sign
        predictionModel.prediction shouldBe predictionResponse.prediction

    }
}