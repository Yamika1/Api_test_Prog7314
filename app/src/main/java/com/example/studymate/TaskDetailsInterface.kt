package com.example.studymate
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Insert

@Dao
interface TaskDetailsInterface {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun taskDetails(details: TaskDetails)

    @Query("SELECT * FROM tblTaskDetails ORDER BY id ASC")
    fun readAllData(): LiveData<List<TaskDetails>>
}