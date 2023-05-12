package com.mytakeitapp.feature_add_publication.di

import com.mytakeitapp.feature_add_publication.data.TakeItAddPublicationRepositoryImpl
import com.mytakeitapp.feature_add_publication.domain.repository.TakeItAddPublicationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface AddPublicationModule {

    @Binds
    @Singleton
    fun bindRepository(repository: TakeItAddPublicationRepositoryImpl): TakeItAddPublicationRepository
}