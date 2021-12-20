package com.elovo.data.repository

import com.elovo.data.datasource.dao.NoteDAO
import com.elovo.data.model.NoteDataModel
import com.elovo.domain.entity.Note
import com.elovo.domain.repository.NoteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

class NoteRepositoryImpl(
    private val noteDAO: NoteDAO
) : NoteRepository {
    @ExperimentalCoroutinesApi
    override fun getNotes(): Flow<List<Note>> {
        val notes = noteDAO.getNotes()
        return notes.mapLatest { list -> list.map { it.mapToCoreModel() } }
    }

    override suspend fun getNoteById(id: Int) = noteDAO.getNoteById(id)?.mapToCoreModel()

    override suspend fun insertNote(note: Note) = noteDAO.insertNote(NoteDataModel.from(note))

    override suspend fun deleteNote(note: Note) = noteDAO.deleteNote(NoteDataModel.from(note))
}