package com.elovo.data.util

interface CoreMapper<T: Any> {
    fun mapToCoreModel(): T
}

interface RoomMapper<out T: Any> {
    fun mapToRoomEntity(): T
}