package com.example.studymate

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskAddInterface {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: TaskAdd)

    @Update
    suspend fun updateTask(task: TaskAdd)

    @Delete
    suspend fun deleteTask(task: TaskAdd)

    @Query("SELECT * FROM tblTask ORDER BY id DESC")
    fun readAllData(): LiveData<List<TaskAdd>>

    @Query("SELECT * FROM tblTask WHERE id = :taskId LIMIT 1")
    fun getTaskById(taskId: Int): LiveData<TaskAdd?>
}
