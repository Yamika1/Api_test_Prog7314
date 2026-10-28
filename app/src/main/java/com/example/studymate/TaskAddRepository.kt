package com.example.studymate

class TaskAddRepository(
    private val taskDao: TaskAddInterface
) {
    val readAllData = taskDao.readAllData()

    fun getTaskById(id: Int) = taskDao.getTaskById(id)

    suspend fun addTask(task: TaskAdd) {
        taskDao.addTask(task)
    }

    suspend fun updateTask(task: TaskAdd) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: TaskAdd) {
        taskDao.deleteTask(task)
    }
}
