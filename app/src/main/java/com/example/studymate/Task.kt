package com.example.studymate

data class Task(
    val id: Long,
    var name: String,
    var description: String,
    var category: String,
    var priority: String,
    var dueDate: String,
    var completed: Boolean = false
)
