package ru.effective.booking.dto

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") val id: Int,
    @SerializedName("hotel_name") val name: String,
    @SerializedName("hotel_adress") val adress: String,
    @SerializedName("horating")val rating: Int,
    @SerializedName("rating_name")val ratingName: String,
    @SerializedName("departure")val departure: String,
    @SerializedName("arrival_country")val arrivalCountry: String,
    @SerializedName("tour_date_start")val dateStart: String,
    @SerializedName("tour_date_stop")val dateEnd: String,
    @SerializedName("number_of_nights")val nights: Int,
    @SerializedName("room")val room: String,
    @SerializedName("nutrition")val nutrition: String,
    @SerializedName("tour_price")val tourPrice: Int,
    @SerializedName("fuel_charge") val fuel: Int,
    @SerializedName("service_charge") val service: Int
)