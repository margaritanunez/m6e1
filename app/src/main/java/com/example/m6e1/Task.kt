package com.example.m6e1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "task_table")
data class Task( val nombreTarea: String){
    @PrimaryKey(autoGenerate = true) var id : Long = 0
}


