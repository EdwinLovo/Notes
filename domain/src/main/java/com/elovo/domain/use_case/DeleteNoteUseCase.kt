package com.elovo.domain.use_case

import com.elovo.domain.entity.Note
import com.elovo.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) = repository.deleteNote(note)
}