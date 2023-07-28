package com.example.m6e1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository
    init {
        repository = Repository(TaskDataBase.getDataBase(application).getTaskDao())
    }
    fun  obtenerTareas(): LiveData<List<Task>> {
        return repository.getTareas()

    }
    fun insertarTareas(task: Task) = viewModelScope.launch{
        repository.insertarTarea(task)
    }
}