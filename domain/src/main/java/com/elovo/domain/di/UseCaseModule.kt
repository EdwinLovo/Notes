package com.elovo.domain.di

import com.elovo.domain.repository.NoteRepository
import com.elovo.domain.use_case.AddNoteUseCase
import com.elovo.domain.use_case.DeleteNoteUseCase
import com.elovo.domain.use_case.GetNoteUseCase
import com.elovo.domain.use_case.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun providesGetNotes(
        repository: NoteRepository
    ): GetNotesUseCase = GetNotesUseCase(repository)

    @Provides
    @ViewModelScoped
    fun providesDeleteNote(
        repository: NoteRepository
    ): DeleteNoteUseCase = DeleteNoteUseCase(repository)

    @Provides
    @ViewModelScoped
    fun providesAddNote(
        repository: NoteRepository
    ): AddNoteUseCase = AddNoteUseCase(repository)

    @Provides
    @ViewModelScoped
    fun providesGetNote(
        repository: NoteRepository
    ): GetNoteUseCase = GetNoteUseCase(repository)

}