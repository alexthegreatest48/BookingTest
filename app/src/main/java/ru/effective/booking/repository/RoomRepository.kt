package ru.effective.booking.repository

import kotlinx.coroutines.flow.Flow
import ru.effective.booking.dto.Room

interface RoomRepository {
    val data: Flow<List<Room>>
    suspend fun getRoom()
}