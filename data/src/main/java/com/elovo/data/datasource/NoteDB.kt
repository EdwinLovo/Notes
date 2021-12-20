package com.elovo.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elovo.data.datasource.dao.NoteDAO
import com.elovo.data.model.NoteDataModel

@Database(
    entities = [NoteDataModel::class],
    version = 1
)
abstract class NoteDB : RoomDatabase() {

    abstract val noteDAO: NoteDAO

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}