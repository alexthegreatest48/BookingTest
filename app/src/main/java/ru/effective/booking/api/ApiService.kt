package ru.effective.booking.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.effective.booking.dto.Book
import ru.effective.booking.dto.Hotel
import ru.effective.booking.dto.Room
import ru.effective.booking.dto.RoomList

private const val BASE_URL = "https://run.mocky.io/v3/"

private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
}

private val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okhttp)
    .build()

interface ApiService {
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel(): Response<Hotel>

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoom(): Response<RoomList>

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBook(): Response<Book>

}

object Api {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}