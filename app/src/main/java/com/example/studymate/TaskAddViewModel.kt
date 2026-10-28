package com.example.studymate
import androidx.lifecycle.AndroidViewModel
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskAddViewModel(application:Application) :AndroidViewModel(application) {

    private val readAllData : LiveData<List<TaskAdd>>

    private val repository: TaskAddRepository

    init{
        val add = TaskAddDatabase.getDatabase(application).taskAdd()
        repository= TaskAddRepository(add)
        readAllData = repository.readAllData

    }

    fun addTask(task: TaskAdd){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }

    }
}