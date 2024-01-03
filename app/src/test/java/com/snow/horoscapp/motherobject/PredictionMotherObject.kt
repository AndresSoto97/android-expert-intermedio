package com.snow.horoscapp.motherobject

import com.snow.horoscapp.data.network.response.PredictionResponse
import com.snow.horoscapp.domain.model.HoroscopeInfo

object PredictionMotherObject {
    val anyResponse = PredictionResponse("date", "Aasdasdasdasd", "Taurus")
    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}