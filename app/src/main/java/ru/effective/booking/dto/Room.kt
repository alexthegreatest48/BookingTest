package ru.effective.booking.dto

data class Room(
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: String,
    val image: String
)