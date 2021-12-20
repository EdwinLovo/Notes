package com.elovo.data.datasource.dao

import androidx.room.*
import com.elovo.data.model.NoteDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Query("SELECT * FROM NoteDataModel")
    fun getNotes(): Flow<List<NoteDataModel>>

    @Query("SELECT * FROM NoteDataModel WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteDataModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteDataModel)

    @Delete
    suspend fun deleteNote(note: NoteDataModel)
}