package ru.effective.booking.model

import ru.effective.booking.dto.Book

data class BookModel(
    val book: List<Book> = emptyList(),
    val empty: Boolean = false,
)