package com.example.studymate
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import android.content.Context

@Database(entities= [TaskAdd:: class], version = 1, exportSchema = false)
abstract class TaskAddDatabase :RoomDatabase(){

    abstract fun taskAdd(): TaskAddInterface

    companion object{
        @Volatile
        private var INSTANCE: TaskAddDatabase? =null

        fun getDatabase(context:Context): TaskAddDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskAddDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}