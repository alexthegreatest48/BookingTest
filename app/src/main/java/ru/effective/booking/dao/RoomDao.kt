package ru.effective.booking.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.effective.booking.entity.RoomEntity

@Dao
interface RoomDao {
    @Query("SELECT * FROM RoomEntity ORDER BY id DESC")
    fun getAll(): Flow<List<RoomEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(room: List<RoomEntity>)
}