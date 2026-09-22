package com.example.studymate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class TaskDetailsFragment : Fragment() {
    private lateinit var btnBack: Button
    private lateinit var textviewTaskName: TextView
    private lateinit var textviewTaskDescription: TextView
    private lateinit var textviewTaskCategory: TextView
    private lateinit var textviewTaskPriority: TextView
    private lateinit var textviewTaskDueDate: TextView
    private lateinit var textviewTaskStatus: TextView
    private lateinit var btnMarkComplete: Button
    private lateinit var btnEditTask: Button
    private lateinit var btnDeleteTask: Button

    private var taskId: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskId = arguments?.getLong("taskId") ?: 0L
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_task_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBack = view.findViewById(R.id.btnBack)
        textviewTaskName = view.findViewById(R.id.textviewTaskName)
        textviewTaskDescription = view.findViewById(R.id.textviewTaskDescription)
        textviewTaskDueDate = view.findViewById(R.id.textviewTaskDueDate)
        textviewTaskCategory = view.findViewById(R.id.textviewTaskCategory)
        textviewTaskPriority = view.findViewById(R.id.textviewTaskPriority)
        textviewTaskStatus = view.findViewById(R.id.textviewTaskStatus)
        btnMarkComplete = view.findViewById(R.id.btnMarkComplete)
        btnEditTask = view.findViewById(R.id.btnEditTask)
        btnDeleteTask = view.findViewById(R.id.btnDeleteTask)

        btnBack.setOnClickListener { parentFragmentManager.popBackStack() }
        loadTask()

        btnMarkComplete.setOnClickListener {
            TaskStorage.markComplete(requireContext(), taskId)
            Toast.makeText(requireContext(), "Task marked as complete", Toast.LENGTH_SHORT).show()
            loadTask()
        }

        btnEditTask.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AddTaskFragment().apply {
                    arguments = Bundle().apply { putLong("taskId", taskId) }
                })
                .addToBackStack(null)
                .commit()
        }

        btnDeleteTask.setOnClickListener {
            TaskStorage.deleteTask(requireContext(), taskId)
            Toast.makeText(requireContext(), "Task deleted", Toast.LENGTH_SHORT).show()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, TaskFragment())
                .commit()
        }
    }

    private fun loadTask() {
        val task = TaskStorage.getTask(requireContext(), taskId)
        if (task == null) {
            Toast.makeText(requireContext(), "Task not found", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
            return
        }

        textviewTaskName.text = task.name
        textviewTaskDescription.text = task.description.ifEmpty { "No description" }
        textviewTaskCategory.text = task.category
        textviewTaskPriority.text = task.priority
        textviewTaskDueDate.text = task.dueDate
        textviewTaskStatus.text = if (task.completed) "Completed" else "Incomplete"
        btnMarkComplete.isEnabled = !task.completed
        btnMarkComplete.text = if (task.completed) "Completed" else "Mark as Complete"
    }
}
