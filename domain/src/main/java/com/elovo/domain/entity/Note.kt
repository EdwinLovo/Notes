package com.elovo.domain.entity

data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val id: Int? = null
) {
    class InvalidNoteException(message: String): Exception(message)
}

