package com.example.studymate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class AddTaskFragment : Fragment() {
    private lateinit var taskName: EditText

    private lateinit var taskDescription: EditText

    private lateinit var  spCategory: Spinner

    private lateinit var spinnerPriority: Spinner

    private lateinit var dueDate: EditText

    private lateinit var btnSaveTask: Button

    private lateinit var backToHome : Button


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
        btnSaveTask = view.findViewById<Button>(R.id.btnSaveTask)
        backToHome = view.findViewById<Button>(R.id.backToHome)


        backToHome.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }

        val categoryItems : ArrayList<String> = arrayListOf("Wellness", "Fitness", "Academic", "Work", "Personal")
        val categoryAdapter= ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categoryItems)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
         spCategory.adapter = categoryAdapter



        val priority_items : ArrayList<String> = arrayListOf("High", "Medium", "Low")
        val priorityAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,priority_items)
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerPriority.adapter = priorityAdapter


        btnSaveTask.setOnClickListener {
           val taskName = taskName.text.toString().trim()
           val taskDescription = taskDescription.text.toString().trim()
            val dueDate= dueDate.text.toString().trim()
            val selectedCategory : String = spCategory.selectedItem.toString()
            val selectedPriority : String =  spinnerPriority.selectedItem.toString()

            if (taskName.isEmpty()){
             Toast.makeText(requireContext(),"Task Name is required",Toast.LENGTH_SHORT).show()
            }else if(dueDate.isEmpty() ){
                Toast.makeText(requireContext(),"Due Date is required",Toast.LENGTH_SHORT).show()
            }else if(selectedCategory.isEmpty()){
                Toast.makeText(requireContext(),"Task Category is required",Toast.LENGTH_SHORT).show()
            }else if(selectedPriority.isEmpty()){
                Toast.makeText(requireContext(),"Task Priority is required",Toast.LENGTH_SHORT).show()
            }else{
                //api call to send data to db

             /*   if (apiCall is successful {
                Toast.makeText(requireContext(),"New Task Created!",Toast.LENGTH_SHORT).show()
                    clearTextFields()
                }else{
                 Toast.makeText(requireContext(),"Task Creation Failed",Toast.LENGTH_SHORT).show()
                 }
                */
            }

        }

    }

    private fun clearTextFields(){
        taskName.text.clear()
        taskDescription.text.clear()

    }


}
