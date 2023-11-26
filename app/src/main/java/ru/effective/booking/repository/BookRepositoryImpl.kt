package ru.effective.booking.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.effective.booking.api.Api
import ru.effective.booking.dao.BookDao
import ru.effective.booking.entity.BookEntity
import ru.effective.booking.entity.toDto
import ru.effective.booking.entity.toEntity

class BookRepositoryImpl(private val dao: BookDao) : BookRepository {
    override val data = dao.getAll()
        .map(List<BookEntity>::toDto)
        .flowOn(Dispatchers.Default)

    override suspend fun getBook() {
            val response = Api.service.getBook()

            val body = response.body()
            dao.insert(BookEntity.fromDto(body!!))
    }
}