package ru.effective.booking.dto

import androidx.room.TypeConverter
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


data class Hotel(
    @SerializedName("id")val id: Int,
    @SerializedName("name")val name: String,
    @SerializedName("adress") val adress: String,
    @SerializedName("minimal_price")val minimalPrice: Int,
    @SerializedName("price_for_it")val priceForIt: String,
    @SerializedName("rating") val rating: Int,
    @SerializedName("rating_name") val ratingName: String,
    @SerializedName("image_urls") val image: List<String>,
    @SerializedName("about_the_hotel") val about: About
) {
}

data class About(
    val description : String,
    val peculiarities : List<String>
)

class Converters {
    @TypeConverter
    fun fromList(value : List<String>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<String>>(value)
}