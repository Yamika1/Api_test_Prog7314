package com.example.studymate
import androidx.lifecycle.LiveData

class TaskDetailsRepository(private val taskDtls: TaskDetailsInterface){
    val readAllData:LiveData<List<TaskDetails>> = taskDtls.readAllData()

    suspend fun taskDetails(Details: TaskDetails){
        taskDtls.taskDetails(Details)
    }

}
