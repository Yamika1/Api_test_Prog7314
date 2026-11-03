package com.example.studymate

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TaskAdd::class],
    version = 2,
    exportSchema = false
)
abstract class TaskAddDatabase : RoomDatabase() {

    abstract fun taskAdd(): TaskAddInterface

    companion object {
        @Volatile
        private var INSTANCE: TaskAddDatabase? = null

        fun getDatabase(context: Context): TaskAddDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TaskAddDatabase::class.java,
                    "task_add_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
