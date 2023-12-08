package ru.effective.booking.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.effective.booking.dto.About
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
    val image: List<String>,
    @Embedded
    val about: AboutEmbeddable
) {
    fun toDto() = Hotel(id, name, adress, minimalPrice, priceForIt, rating, ratingName, image, about.toDto())

    companion object {
        fun fromDto(dto: Hotel) =
            HotelEntity(dto.id, dto.name, dto.adress, dto.minimalPrice, dto.priceForIt, dto.rating, dto.ratingName, dto.image, AboutEmbeddable.fromDto(dto.about))
    }
}

data class AboutEmbeddable(
    val description : String,
    val peculiarities : List<String>
) {
    fun toDto() = About(description, peculiarities)

    companion object {
        fun fromDto(dto: About) = dto.let {
            AboutEmbeddable(it.description, it.peculiarities)
        }
    }
}

fun List<HotelEntity>.toDto(): List<Hotel> = map(HotelEntity::toDto)

