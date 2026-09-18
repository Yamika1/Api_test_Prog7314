package com.example.studymate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView


class AddTaskFragment : Fragment() {
    private lateinit var taskName: EditText

    private lateinit var taskDescription: EditText

    private lateinit var  spCategory: Spinner

    private lateinit var spinnerPriority: Spinner

    private lateinit var dueDate: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskName = view.findViewById<EditText>(R.id.taskName)
        taskDescription = view.findViewById<EditText>(R.id.taskDescription)
        dueDate = view.findViewById<EditText>(R.id.dueDate)
        spCategory = view.findViewById<Spinner>(R.id.spCategory)
        spinnerPriority = view.findViewById<Spinner>(R.id.spinnerPriority)

    }

}

