package com.snow.horoscapp.ui.lucky

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.snow.horoscapp.R
import com.snow.horoscapp.databinding.FragmentLuckyBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

@AndroidEntryPoint
class LuckyFragment : Fragment() {

    private var _binding: FragmentLuckyBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        binding.ivRulete.setOnClickListener { spinRulete() }
    }

    private fun spinRulete() {
        val random = Random()
        val degrees = random.nextInt(1440) + 360
        val animator = ObjectAnimator.ofFloat(binding.ivRulete, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                binding.ivReverseSmall.isVisible = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.ivReverseSmall.startAnimation(slideUpAnimation)
    }

    private fun growCard() {
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow_card)
        growAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                binding.ivReverseSmall.isVisible = false
                showPredictionView()

            }
            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.ivReverseSmall.startAnimation(growAnimation)
    }

    private fun showPredictionView() {
        val disapearAnimation = AlphaAnimation(1.0f, 0.0f)
        disapearAnimation.duration = 200

        val appearPredictionAnim = AlphaAnimation(0.0f, 1.0f)
        appearPredictionAnim.duration = 1000

        disapearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.preview.startAnimation(disapearAnimation)
        binding.prediction.startAnimation(appearPredictionAnim)
    }
}