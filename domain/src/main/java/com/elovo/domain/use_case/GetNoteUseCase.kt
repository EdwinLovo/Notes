package com.elovo.domain.use_case

import com.elovo.domain.entity.Note
import com.elovo.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? = repository.getNoteById(id)
}