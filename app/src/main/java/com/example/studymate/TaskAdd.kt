package com.example.studymate

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblTask")
data class TaskAdd(
    val name: String,
    val description: String,
    val category: String,
    val priority: String,
    val dueDate: String,
    val status: String = "Incomplete",

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
