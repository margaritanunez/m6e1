package com.example.m6e1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Task:: class], version = 1)
abstract class TaskDataBase : RoomDatabase(){

    abstract fun getTaskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDataBase(context: Context): TaskDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                TaskDataBase:: class.java,
                "task_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}