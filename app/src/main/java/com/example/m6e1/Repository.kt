package com.example.m6e1

import androidx.lifecycle.LiveData

class Repository(private val taskDao: TaskDao) {
    suspend fun insertarTarea(task: Task){
        taskDao.insertTask(task)

    }
    fun getTareas() : LiveData<List<Task>> {
        return taskDao.getTasks()
    }
}