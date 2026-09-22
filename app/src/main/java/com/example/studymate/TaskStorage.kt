package com.example.studymate

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object TaskStorage {
    private const val PREFS_NAME = "StudyMateTasks"
    private const val TASKS_KEY = "tasks"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getTasks(context: Context): MutableList<Task> {
        val json = prefs(context).getString(TASKS_KEY, "[]") ?: "[]"
        val result = mutableListOf<Task>()

        return try {
            val array = JSONArray(json)
            for (i in 0 until array.length()) {
                val item = array.getJSONObject(i)
                result.add(
                    Task(
                        id = item.optLong("id"),
                        name = item.optString("name"),
                        description = item.optString("description"),
                        category = item.optString("category"),
                        priority = item.optString("priority"),
                        dueDate = item.optString("dueDate"),
                        completed = item.optBoolean("completed", false)
                    )
                )
            }
            result
        } catch (_: Exception) {
            mutableListOf()
        }
    }

    private fun saveTasks(context: Context, tasks: List<Task>) {
        val array = JSONArray()
        tasks.forEach { task ->
            array.put(
                JSONObject().apply {
                    put("id", task.id)
                    put("name", task.name)
                    put("description", task.description)
                    put("category", task.category)
                    put("priority", task.priority)
                    put("dueDate", task.dueDate)
                    put("completed", task.completed)
                }
            )
        }
        prefs(context).edit().putString(TASKS_KEY, array.toString()).apply()
    }

    fun addTask(context: Context, task: Task) {
        val tasks = getTasks(context)
        tasks.add(task)
        saveTasks(context, tasks)
    }

    fun getTask(context: Context, id: Long): Task? =
        getTasks(context).firstOrNull { it.id == id }

    fun markComplete(context: Context, id: Long) {
        val tasks = getTasks(context)
        tasks.firstOrNull { it.id == id }?.completed = true
        saveTasks(context, tasks)
    }

    fun updateTask(context: Context, task: Task) {
        val tasks = getTasks(context)
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index >= 0) {
            tasks[index] = task
            saveTasks(context, tasks)
        }
    }

    fun deleteTask(context: Context, id: Long) {
        val tasks = getTasks(context)
        tasks.removeAll { it.id == id }
        saveTasks(context, tasks)
    }
}
