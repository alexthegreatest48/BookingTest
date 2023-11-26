package ru.effective.booking.model


import ru.effective.booking.dto.Hotel

data class HotelModel(
    val hotel: List<Hotel> = emptyList(),
    val empty: Boolean = false,
)