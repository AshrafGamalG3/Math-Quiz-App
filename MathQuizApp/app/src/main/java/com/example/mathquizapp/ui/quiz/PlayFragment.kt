package com.example.mathquizapp.ui.quiz

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mathquizapp.R
import com.example.mathquizapp.databinding.FragmentPlayBinding
import com.example.mathquizapp.question.Question
import com.example.mathquizapp.question.QuestionList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayFragment : Fragment() {
    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!
    private var position = 0
    private var timer: CountDownTimer? = null
    private var timeGiven = 0
    private var score = 0
    private var questionDataList = ArrayList<Question>(10)
    private val args: PlayFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val questionType = args.questionType
        questionDataList = QuestionList(questionType).getQuestionList()
        setGivenTime(questionType)
        updateQuestion()
        updateOption()
        updateHorizontalProgressBar()
        startTimer()
        binding.btnOption1.setOnClickListener { onSelectOption(binding.btnOption1.text.toString()) }
        binding.btnOption2.setOnClickListener { onSelectOption(binding.btnOption2.text.toString()) }
        binding.btnOption3.setOnClickListener { onSelectOption(binding.btnOption3.text.toString()) }
        binding.btnOption4.setOnClickListener { onSelectOption(binding.btnOption4.text.toString()) }
    }

    private fun updateQuestion() {
        binding.questionText.text = questionDataList[position].problem
    }

    private fun updateOption() {
        binding.btnOption1.text = questionDataList[position].option1
        binding.btnOption2.text = questionDataList[position].option2
        binding.btnOption3.text = questionDataList[position].option3
        binding.btnOption4.text = questionDataList[position].option4
    }

    private fun updateHorizontalProgressBar() {
        binding.progressBar.progress = position + 1
        binding.progressBar.max = questionDataList.size
    }

    private fun setGivenTime(level: String) {
        timeGiven = when (level) {
            "easy" -> 10000
            "medium" -> 12000
            else -> 15000
        }
    }

    private fun startTimer() {
        val count = timeGiven / 1000
        binding.timeBar.max = count
        binding.timeBar.progress = count

        timer = object : CountDownTimer(timeGiven.toLong(), 1000) {
            var remainingTime = count

            override fun onTick(millisUntilFinished: Long) {
                remainingTime--
                binding.timeBar.progress = remainingTime
                binding.countDown.text = remainingTime.toString()
            }

            override fun onFinish() {
                setNextRound()
            }
        }.start()
    }
    private fun onSelectOption(option: String) {
        if (option == questionDataList[position].answer) {
            score++
        }

        questionDataList[position].selectedOption = option
        setNextRound()
    }

    private fun setNextRound() {
        if (position < questionDataList.size - 1) {
            position++
            timer?.cancel()
            updateHorizontalProgressBar()
            updateQuestion()
            updateOption()
            startTimer()
        } else {
            endGame()
        }
    }

    private fun endGame() {
        navigateToSummaryScreen()
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        timer?.cancel()
    }

    private fun navigateToSummaryScreen() {
        val questionArray = questionDataList.toTypedArray()
        val action = PlayFragmentDirections.actionPlayFragmentToFinishFragment(score.toString(),questionArray)
        findNavController().navigate(action)
    }
}
