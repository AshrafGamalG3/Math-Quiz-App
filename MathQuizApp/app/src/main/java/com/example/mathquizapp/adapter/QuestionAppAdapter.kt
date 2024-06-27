package com.example.mathquizapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mathquizapp.R
import com.example.mathquizapp.question.Question

class QuestionAppAdapter(private val dataset: Array<Question>):RecyclerView.Adapter<QuestionAppAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvProblem:TextView=view.findViewById(R.id.rvTvProblem)
        val option1:TextView=view.findViewById(R.id.rvTvOption1)
        val option2:TextView=view.findViewById(R.id.rvTvOption2)
        val option3:TextView=view.findViewById(R.id.rvTvOption3)
        val option4:TextView=view.findViewById(R.id.rvTvOption4)
        val selectedAnswer:TextView=view.findViewById(R.id.selectedAnswer)
        val correctAnswer:TextView=view.findViewById(R.id.correctAnswer)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvProblem.text=dataset[position].problem
        holder.option1.text=dataset[position].option1
        holder.option2.text=dataset[position].option2
        holder.option3.text=dataset[position].option3
        holder.option4.text=dataset[position].option4
        holder.selectedAnswer.text="Your Answer :${dataset[position].selectedOption}"
        holder.correctAnswer.text="Correct Answer :${dataset[position].answer}"


        if (position%2!=0){
            holder.itemView.setBackgroundColor(Color.parseColor("#000000"))
        }
        else{
            holder.itemView.setBackgroundColor(Color.parseColor("#3c3f41"))
        }
    }


}