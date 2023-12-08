package ru.effective.booking.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.effective.booking.api.Api
import ru.effective.booking.dao.RoomDao
import ru.effective.booking.dto.Room
import ru.effective.booking.dto.RoomList
import ru.effective.booking.entity.RoomEntity
import ru.effective.booking.entity.toDto
import ru.effective.booking.entity.toEntity

class RoomRepositoryImpl(private val dao: RoomDao) : RoomRepository {
    override val data = dao.getAll()
        .map(List<RoomEntity>::toDto)
        .flowOn(Dispatchers.Default)

    override suspend fun getRoom() {
        val response = Api.service.getRoom()

        val body = response.body()
        dao.insert(body!!.list.toEntity())
    }
}

