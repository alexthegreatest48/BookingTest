package ru.effective.booking.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.effective.booking.entity.HotelEntity

@Dao
interface HotelDao {
    @Query("SELECT * FROM HotelEntity ORDER BY id DESC")
    fun getAll(): Flow<List<HotelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hotel: HotelEntity)
}