package com.example.feature_home.di

import com.example.feature_home.data.TakeItHomeRepositoryImpl
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


}