package com.snow.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snow.horoscapp.domain.model.HoroscopeModel
import com.snow.horoscapp.domain.usecase.GetPrediction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPrediction: GetPrediction) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            // Hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) { getPrediction(horoscope.name) } // Hilo secundario
            // Hilo principal
            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.prediction, result.sign, horoscope)
            } else {
                _state.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }

}