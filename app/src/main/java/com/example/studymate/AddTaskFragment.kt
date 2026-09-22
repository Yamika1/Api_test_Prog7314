package com.example.studymate

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddTaskFragment : Fragment() {
    private lateinit var taskName: EditText
    private lateinit var taskDescription: EditText
    private lateinit var spCategory: Spinner
    private lateinit var spinnerPriority: Spinner
    private lateinit var dueDate: EditText
    private lateinit var btnSaveTask: Button
    private lateinit var backToHome: Button

    private var editingTaskId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editingTaskId = arguments?.getLong("taskId")?.takeIf { it != 0L }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_add_task, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskName = view.findViewById(R.id.taskName)
        taskDescription = view.findViewById(R.id.taskDescription)
        dueDate = view.findViewById(R.id.dueDate)
        spCategory = view.findViewById(R.id.spCategory)
        spinnerPriority = view.findViewById(R.id.spinnerPriority)
        btnSaveTask = view.findViewById(R.id.btnSaveTask)
        backToHome = view.findViewById(R.id.backToHome)

        val categories = arrayListOf("Wellness", "Fitness", "Academic", "Work", "Personal")
        spCategory.adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, categories
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        val priorities = arrayListOf("High", "Medium", "Low")
        spinnerPriority.adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, priorities
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        dueDate.setOnClickListener { showDatePicker() }

        editingTaskId?.let { id ->
            TaskStorage.getTask(requireContext(), id)?.let { task ->
                taskName.setText(task.name)
                taskDescription.setText(task.description)
                dueDate.setText(task.dueDate)
                spCategory.setSelection(categories.indexOf(task.category).coerceAtLeast(0))
                spinnerPriority.setSelection(priorities.indexOf(task.priority).coerceAtLeast(0))
                btnSaveTask.text = "Update Task"
            }
        }

        backToHome.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }

        btnSaveTask.setOnClickListener { saveTask() }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                val selected = Calendar.getInstance().apply {
                    set(year, month, day)
                }
                dueDate.setText(SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selected.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun saveTask() {
        val name = taskName.text.toString().trim()
        val description = taskDescription.text.toString().trim()
        val date = dueDate.text.toString().trim()
        val category = spCategory.selectedItem.toString()
        val priority = spinnerPriority.selectedItem.toString()

        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Task Name is required", Toast.LENGTH_SHORT).show()
            return
        }
        if (date.isEmpty()) {
            Toast.makeText(requireContext(), "Due Date is required", Toast.LENGTH_SHORT).show()
            return
        }

        val context = requireContext()
        val existing = editingTaskId?.let { TaskStorage.getTask(context, it) }

        val task = Task(
            id = existing?.id ?: System.currentTimeMillis(),
            name = name,
            description = description,
            category = category,
            priority = priority,
            dueDate = date,
            completed = existing?.completed ?: false
        )

        if (existing == null) {
            TaskStorage.addTask(context, task)
            Toast.makeText(context, "New Task Created!", Toast.LENGTH_SHORT).show()
        } else {
            TaskStorage.updateTask(context, task)
            Toast.makeText(context, "Task Updated!", Toast.LENGTH_SHORT).show()
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, TaskFragment())
            .commit()
    }
}
