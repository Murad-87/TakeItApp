package com.mytakeitapp.feature_user_publication.di

import com.mytakeitapp.feature_user_publication.data.TakeItUserPublicationRepositoryImpl
import com.mytakeitapp.feature_user_publication.domain.repository.TakeItUserPublicationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface UserPublicationModule {

    @Binds
    @Singleton
    fun bindRepository(
        repositoryImpl: TakeItUserPublicationRepositoryImpl
    ): TakeItUserPublicationRepository
}