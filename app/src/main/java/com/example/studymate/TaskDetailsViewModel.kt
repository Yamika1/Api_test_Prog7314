package com.example.studymate
import androidx.lifecycle.AndroidViewModel
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskDetailsViewModel(application:Application) :AndroidViewModel(application) {

    private val readAllData : LiveData<List<TaskDetails>>

    private val repository: TaskDetailsRepository

    init{
        val taskDtls = TaskDetailsDatabase.getDatabase(application).taskDetails()
        repository= TaskDetailsRepository(taskDtls)
        readAllData = repository.readAllData

    }

    fun taskDetails(details: TaskDetails){
        viewModelScope.launch(Dispatchers.IO){
            repository.taskDetails(details)
        }

    }
}