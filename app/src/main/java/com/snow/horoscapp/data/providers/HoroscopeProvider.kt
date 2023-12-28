package com.snow.horoscapp.data.providers

import com.snow.horoscapp.domain.model.HoroscopeInfo
import com.snow.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.snow.horoscapp.domain.model.HoroscopeInfo.Aries
import com.snow.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.snow.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.snow.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.snow.horoscapp.domain.model.HoroscopeInfo.Leo
import com.snow.horoscapp.domain.model.HoroscopeInfo.Libra
import com.snow.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.snow.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.snow.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.snow.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.snow.horoscapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}