package com.example.studymate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView


class TaskDetailsFragment : Fragment() {
    private lateinit var btnBack: Button
    private lateinit var textviewTaskName: TextView
    private lateinit var textviewTaskDescription: TextView
    private lateinit var textviewTaskCategory: TextView
    private lateinit var textviewTaskPriority: TextView
    private lateinit var textviewTaskDueDate: TextView
    private lateinit var textviewTaskStatus : TextView
    private lateinit var btnMarkComplete : Button
    private lateinit var btnEditTask: Button
    private lateinit var btnDeleteTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBack = view.findViewById<Button>(R.id.btnSaveTask)
        textviewTaskName = view.findViewById<TextView>(R.id.textviewTaskName)
        textviewTaskDescription = view.findViewById<TextView>(R.id.textviewTaskDescription)
        textviewTaskDueDate = view.findViewById<TextView>(R.id.textviewTaskDueDate)
        textviewTaskCategory = view.findViewById<TextView>(R.id.textviewTaskCategory)
        textviewTaskPriority = view.findViewById<TextView>(R.id.textviewTaskPriority)
        textviewTaskStatus = view.findViewById<TextView>(R.id.textviewTaskStatus)
        btnMarkComplete = view.findViewById<Button>(R.id.btnMarkComplete)
        btnEditTask = view.findViewById<Button>(R.id.btnEditTask)
        btnDeleteTask = view.findViewById<Button>(R.id.btnDeleteTask)

    }

}






