package com.example.takeitapp.di

import android.app.Application
import androidx.room.Room
import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.local.database.TakeItAppDatabase
import com.example.takeitapp.data.repository.TakeItRepositoryImpl
import com.example.takeitapp.domain.repository.TakeItRepository
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
    fun provideRepository(
        dao: TakeItDao,
    ): TakeItRepository {
        return TakeItRepositoryImpl(dao)
    }

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