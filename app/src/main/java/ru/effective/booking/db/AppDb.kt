package ru.effective.booking.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.effective.booking.dao.BookDao
import ru.effective.booking.dao.HotelDao
import ru.effective.booking.dao.RoomDao
import ru.effective.booking.dto.Converters
import ru.effective.booking.entity.BookEntity
import ru.effective.booking.entity.HotelEntity
import ru.effective.booking.entity.RoomEntity

@Database(entities = [BookEntity::class, RoomEntity::class, HotelEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDb : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun roomDao(): RoomDao
    abstract fun hotelDao(): HotelDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
