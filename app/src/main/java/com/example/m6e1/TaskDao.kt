package com.example.m6e1

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)
}