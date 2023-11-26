package ru.effective.booking.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.effective.booking.dto.Hotel

@Entity
data class HotelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val adress: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val image: String,
    val about: String
) {
    fun toDto() = Hotel(id, name, adress, minimalPrice, priceForIt, rating, ratingName, image, about)

    companion object {
        fun fromDto(dto: Hotel) =
            HotelEntity(dto.id, dto.name, dto.adress, dto.minimalPrice, dto.priceForIt, dto.rating, dto.ratingName, dto.image, dto.about)
    }
}

fun List<HotelEntity>.toDto(): List<Hotel> = map(HotelEntity::toDto)

