package com.elovo.data.di

import android.app.Application
import androidx.room.Room
import com.elovo.data.datasource.NoteDB
import com.elovo.data.datasource.dao.NoteDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DBModule {

    @Provides
    @Singleton
    fun provideNoteDB(app: Application): NoteDB {
        return Room.databaseBuilder(
            app,
            NoteDB::class.java,
            NoteDB.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideNoteDAO(db: NoteDB): NoteDAO {
        return db.noteDAO
    }
}