package com.elovo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elovo.data.util.CoreMapper
import com.elovo.domain.entity.Note

@Entity
data class NoteDataModel(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null
) : CoreMapper<Note> {

    override fun mapToCoreModel(): Note {
        return Note(
            title = title,
            content = content,
            timestamp = timestamp,
            color = color,
            id = id
        )
    }

    companion object {
        fun from(note: Note): NoteDataModel = NoteDataModel(
            title = note.title,
            content = note.content,
            timestamp = note.timestamp,
            color = note.color,
            id = note.id
        )
    }
}