package com.example.takeitapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.local.model.TakeItDbModel

@Database(entities = [TakeItDbModel::class], version = 3, exportSchema = false)
abstract class TakeItAppDatabase: RoomDatabase() {
    companion object {
        private var db: TakeItAppDatabase? = null
        const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): TakeItAppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        TakeItAppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun takeItDao() : TakeItDao
}