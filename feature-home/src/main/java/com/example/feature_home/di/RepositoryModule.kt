package com.example.feature_home.di

import com.example.feature_home.data.repository.TakeItHomeDetailsRepositoryImpl
import com.example.feature_home.data.repository.TakeItHomeRepositoryImpl
import com.example.feature_home.domain.repository.TakeItHomeDetailsRepository
import com.example.feature_home.domain.repository.TakeItHomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepositoryHome(repositoryImpl: TakeItHomeRepositoryImpl): TakeItHomeRepository

    @Binds
    @Singleton
    fun bindRepositoryDetails(
        repositoryDetailsImpl: TakeItHomeDetailsRepositoryImpl
    ): TakeItHomeDetailsRepository
}