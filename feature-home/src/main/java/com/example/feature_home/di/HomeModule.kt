package com.example.feature_home.di

import com.example.feature_home.navigation.HomeApi
import com.example.feature_home.navigation.HomeApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object HomeModule {

    @Provides
    fun provideHomeApi(): HomeApi{
        return HomeApiImpl()
    }


}