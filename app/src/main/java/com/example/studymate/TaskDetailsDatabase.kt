package com.example.studymate
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import android.content.Context

@Database(entities= [TaskDetails:: class], version = 1, exportSchema = false)
abstract class TaskDetailsDatabase :RoomDatabase(){

    abstract fun taskDetails(): TaskDetailsInterface

    companion object{
        @Volatile
        private var INSTANCE: TaskDetailsDatabase? =null

        fun getDatabase(context:Context): TaskDetailsDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDetailsDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}