package com.example.takeitapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.local.model.TakeItDbModel

@Database(entities = [TakeItDbModel::class], version = 10, exportSchema = false)
abstract class TakeItAppDatabase : RoomDatabase() {

    abstract fun takeItDao(): TakeItDao

    companion object {
        const val DB_NAME = "main.db"
    }
}