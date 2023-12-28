package com.snow.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.snow.horoscapp.databinding.ItemHoroscopeBinding
import com.snow.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscopeName.setText(horoscopeInfo.name)

        binding.itemHoroscope.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope) { onItemSelected(horoscopeInfo) }
//
        }
    }

    private fun startRotationAnimation(view: View, onEndAnimation:()->Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ onEndAnimation() }
            start()
        }
    }
}