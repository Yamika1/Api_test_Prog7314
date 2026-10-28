package com.example.studymate
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Insert

@Dao
interface TaskAddInterface {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: TaskAdd)

    @Query("SELECT * FROM tblTask ORDER BY id ASC")
    fun readAllData(): LiveData<List<TaskAdd>>
}