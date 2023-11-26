package ru.effective.booking.repository

import kotlinx.coroutines.flow.Flow
import ru.effective.booking.dto.Hotel

interface HotelRepository {
    val data: Flow<List<Hotel>>
    suspend fun getHotel()
}