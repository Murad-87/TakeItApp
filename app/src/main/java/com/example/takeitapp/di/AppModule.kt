package com.example.takeitapp.di

import com.example.feature_home.navigation.HomeApi
import com.example.takeitapp.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(homeApi: HomeApi): NavigationProvider{
        return NavigationProvider(homeApi)
    }
}