package ru.effective.booking.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.effective.booking.entity.BookEntity

@Dao
interface BookDao {
    @Query("SELECT * FROM BookEntity ORDER BY id DESC")
    fun getAll(): Flow<List<BookEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: BookEntity)
}