package ru.effective.booking.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.effective.booking.dto.Book

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val adress: String,
    val rating: Int,
    val ratingName: String,
    val departure: String,
    val arrivalCountry: String,
    val dateStart: String,
    val dateEnd: String,
    val nights: Int,
    val room: String,
    val nutrition: String,
    val tourPrice: Int,
    val fuel: Int,
    val service: Int
) {
    fun toDto() = Book(id, name, adress, rating, ratingName, departure, arrivalCountry, dateStart, dateEnd, nights, room, nutrition, tourPrice, fuel, service)

    companion object {
        fun fromDto(dto: Book) =
            BookEntity(dto.id, dto.name, dto.adress, dto.rating, dto.ratingName, dto.departure, dto.arrivalCountry, dto.dateStart, dto.dateEnd, dto.nights, dto.room, dto.nutrition, dto.tourPrice, dto.fuel, dto.service)
    }
}

fun List<BookEntity>.toDto(): List<Book> = map(BookEntity::toDto)

