package com.example.studymate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView


class TaskFragment : Fragment() {
private lateinit var searchTasks: EditText
    private lateinit var filterAll: Button
    private lateinit var filterAssignments: Button
    private lateinit var filterTests: Button
    private lateinit var filterExams : Button
    private lateinit var taskRecyclerView : RecyclerView

    private lateinit var backToHome : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchTasks = view.findViewById<EditText>(R.id.searchTasks)
        filterAll = view.findViewById<Button>(R.id.filterAll)
        filterAssignments = view.findViewById<Button>(R.id.filterAssignments)
        filterTests = view.findViewById<Button>(R.id.filterTests)
        filterExams = view.findViewById<Button>(R.id.filterExams)
        taskRecyclerView = view.findViewById<RecyclerView>(R.id.taskRecyclerView)


        backToHome = view.findViewById<Button>(R.id.backToHome)


        backToHome.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }
    }


    
}