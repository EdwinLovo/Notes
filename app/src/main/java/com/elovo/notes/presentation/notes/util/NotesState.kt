package com.elovo.notes.presentation.notes.util

import com.elovo.domain.entity.Note
import com.elovo.domain.util.NoteOrder
import com.elovo.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)