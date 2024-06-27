package com.example.mathquizapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mathquizapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.easyButton.setOnClickListener { startGame("easy") }
        binding.mediumButton.setOnClickListener { startGame("medium") }
        binding.hardButton.setOnClickListener { startGame("hard") }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startGame(questionType: String) {
        val action = HomeFragmentDirections.actionHomeFragmentToPlayFragment(questionType)
        findNavController().navigate(action)
    }
}
