
package com.example.studymate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskAddViewModel(application: Application) :
    AndroidViewModel(application) {

    private val repository: TaskAddRepository

    val allTasks: LiveData<List<TaskAdd>>

    init {
        val dao = TaskAddDatabase.getDatabase(application).taskAdd()
        repository = TaskAddRepository(dao)
        allTasks = repository.readAllData
    }

    fun getTaskById(id: Int): LiveData<TaskAdd?> {
        return repository.getTaskById(id)
    }

    fun addTask(task: TaskAdd) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }

    fun updateTask(task: TaskAdd) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: TaskAdd) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(task)
        }
    }
}
