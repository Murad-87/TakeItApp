package com.example.takeitapp.di

import android.app.Application
import androidx.room.Room
import com.example.takeitapp.data.api.TakeItApi
import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.local.database.TakeItAppDatabase
import com.example.takeitapp.data.repository.TakeItRepositoryImpl
import com.example.takeitapp.domain.repository.TakeItRepository
import com.example.takeitapp.utils.ApiHelper
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
        api: TakeItApi,
        apiHelper: ApiHelper
    ): TakeItRepository {
        return TakeItRepositoryImpl(dao, api, apiHelper)
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