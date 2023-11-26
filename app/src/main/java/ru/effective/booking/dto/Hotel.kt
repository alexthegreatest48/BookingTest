package ru.effective.booking.dto


data class Hotel(
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
}
