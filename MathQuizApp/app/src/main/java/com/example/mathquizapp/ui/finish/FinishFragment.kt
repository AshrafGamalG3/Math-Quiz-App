package com.example.mathquizapp.ui.finish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mathquizapp.adapter.QuestionAppAdapter
import com.example.mathquizapp.databinding.FragmentFinishBinding
import com.example.mathquizapp.question.Question
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinishFragment : Fragment() {
    private var _binding: FragmentFinishBinding? = null
    private val binding get() = _binding!!

    private val args: FinishFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = args.data
        val score = args.score

        binding.score.text = "Your Score\n$score/10"
        setAdapterRecyclerView(data)
        binding.btnHome.setOnClickListener {
            findNavController().navigate(FinishFragmentDirections.actionFinishFragmentToHomeFragment())
        }

    }

    private fun setAdapterRecyclerView(questionDataList: Array<Question>) {
        val recyclerView = binding.rvQuestionList
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = QuestionAppAdapter(questionDataList)
        recyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
