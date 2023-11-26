package ru.effective.booking.repository

import kotlinx.coroutines.flow.Flow
import ru.effective.booking.dto.Book

interface BookRepository {
    val data: Flow<List<Book>>
    suspend fun getBook()
}