package ru.effective.booking.dto

data class Book(
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
)