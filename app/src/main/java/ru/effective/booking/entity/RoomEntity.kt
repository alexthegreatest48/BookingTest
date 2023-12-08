package ru.effective.booking.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.effective.booking.dto.Room

@Entity
data class RoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val image: List<String>
) {
    fun toDto() = Room(id, name, price, pricePer, peculiarities, image)

    companion object {
        fun fromDto(dto: Room) =
            RoomEntity(dto.id, dto.name, dto.price, dto.pricePer, dto.peculiarities, dto.image)
    }
}

fun List<RoomEntity>.toDto(): List<Room> = map(RoomEntity::toDto)
fun List<Room>.toEntity(): List<RoomEntity> = map(RoomEntity::fromDto)