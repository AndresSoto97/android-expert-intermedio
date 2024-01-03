package com.snow.horoscapp.ui.horoscope

import com.snow.horoscapp.data.providers.HoroscopeProvider
import com.snow.horoscapp.motherobject.PredictionMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.MockKAnnotations.init
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest {
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var  viewModel:HoroscopeViewModel

    @Before
    fun setUp(){
        init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`(){
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value

        assertTrue(horoscopes.isNotEmpty())
    }
}