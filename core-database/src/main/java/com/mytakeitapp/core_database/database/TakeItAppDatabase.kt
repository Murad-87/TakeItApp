package com.mytakeitapp.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mytakeitapp.core_database.dao.TakeItDao
import com.mytakeitapp.core_database.model.TakeItDbModel

@Database(entities = [TakeItDbModel::class], version = 10, exportSchema = false)
abstract class TakeItAppDatabase : RoomDatabase() {

    abstract fun takeItDao(): TakeItDao

    companion object {
        const val DB_NAME = "main.db"
    }
}