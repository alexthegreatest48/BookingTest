package ru.effective.booking.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.effective.booking.api.Api
import ru.effective.booking.dao.HotelDao
import ru.effective.booking.entity.HotelEntity
import ru.effective.booking.entity.toDto

class HotelRepositoryImpl(private val dao: HotelDao) : HotelRepository {
    override val data = dao.getAll()
        .map(List<HotelEntity>::toDto)
        .flowOn(Dispatchers.Default)

    override suspend fun getHotel() {
        val response = Api.service.getHotel()

        val body = response.body()
        dao.insert(HotelEntity.fromDto(body!!))
    }
}