package com.example.studymate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView


class ProgressFragment : Fragment() {
private lateinit var progressCircular: ProgressBar
private lateinit var textviewCompletionPercentage: TextView
private lateinit var textviewCompletedOfTotal: TextView
private lateinit var tvTotalTasks: TextView
private lateinit var textviewCompletedTasks: TextView
private lateinit var textviewIncompleteTasks: TextView
private lateinit var tvOverdueTasks: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressCircular = view.findViewById<ProgressBar>(R.id.progressCircular)
        textviewCompletionPercentage = view.findViewById<TextView>(R.id.textviewCompletionPercentage)
        textviewCompletedOfTotal = view.findViewById<TextView>(R.id.textviewCompletedOfTotal)
        tvTotalTasks = view.findViewById<TextView>(R.id.tvTotalTasks)
        textviewCompletedTasks = view.findViewById<TextView>(R.id.textviewCompletedTasks)
        textviewIncompleteTasks = view.findViewById<TextView>(R.id.textviewIncompleteTasks)
        tvOverdueTasks = view.findViewById<TextView>(R.id.tvOverdueTasks)

    }

}