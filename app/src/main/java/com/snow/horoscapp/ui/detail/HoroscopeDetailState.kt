package com.snow.horoscapp.ui.detail

import com.snow.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    data class Error(val error:String): HoroscopeDetailState()
    data class Success(
        val prediction:String,
        val title:String,
        val horoscopeModel: HoroscopeModel
    ): HoroscopeDetailState()
}