package com.example.m6e1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Query("select * from task_table order by id ASC")
    fun getTasks() : LiveData<List<Task>>

}