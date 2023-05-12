package com.mytakeitapp.core_database.di

import android.app.Application
import androidx.room.Room
import com.mytakeitapp.core_database.dao.TakeItDao
import com.mytakeitapp.core_database.database.TakeItAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideTakeItDatabase(application: Application): TakeItAppDatabase {
        return Room.databaseBuilder(
            application,
            TakeItAppDatabase::class.java,
            TakeItAppDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTakeItDao(database: TakeItAppDatabase): TakeItDao {
        return database.takeItDao()
    }
}