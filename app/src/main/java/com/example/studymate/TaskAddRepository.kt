package com.example.studymate
import androidx.lifecycle.LiveData

class TaskAddRepository(private val taskAdd: TaskAddInterface){
    val readAllData:LiveData<List<TaskAdd>> = taskAdd.readAllData()

    suspend fun addTask(task: TaskAdd){
        taskAdd.addTask(task)
    }

}
