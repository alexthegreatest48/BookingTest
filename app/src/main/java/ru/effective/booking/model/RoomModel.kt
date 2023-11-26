package ru.effective.booking.model


import ru.effective.booking.dto.Room

data class RoomModel(
    val room: List<Room> = emptyList(),
    val empty: Boolean = false,
)