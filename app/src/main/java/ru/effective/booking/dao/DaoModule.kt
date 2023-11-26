package ru.effective.booking.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.effective.booking.db.AppDb

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun providePostDao(db: AppDb): BookDao = db.bookDao()
    @Provides
    fun provideEventDao(db: AppDb): RoomDao = db.roomDao()
    @Provides
    fun provideJobDao(db: AppDb): HotelDao = db.hotelDao()
}