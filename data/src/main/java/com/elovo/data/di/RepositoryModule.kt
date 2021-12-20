package com.elovo.data.di

import com.elovo.data.datasource.dao.NoteDAO
import com.elovo.data.repository.NoteRepositoryImpl
import com.elovo.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RepositoryModule {

    @Provides
    @Singleton
    fun provideNoteRepository(noteDAO: NoteDAO): NoteRepository {
        return NoteRepositoryImpl(noteDAO)
    }
}