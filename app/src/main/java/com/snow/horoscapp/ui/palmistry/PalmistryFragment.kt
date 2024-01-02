package com.snow.horoscapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.snow.horoscapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) startCamera()
            else {
                Toast.makeText(
                    requireContext(),
                    "Acepta los permisos para poder disfrutar de una experiencia magica",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    companion object {
        private const val CAMERA_PERMISSION: String = android.Manifest.permission.CAMERA
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (hasCameraPermission()) startCamera()
        else requestPermissionLauncher.launch(CAMERA_PERMISSION)
    }

    private fun startCamera() {
        TODO("Not yet implemented")
    }

    private fun hasCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}