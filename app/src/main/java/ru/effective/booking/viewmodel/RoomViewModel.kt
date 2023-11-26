package ru.effective.booking.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.effective.booking.db.AppDb
import ru.effective.booking.model.RoomModel
import ru.effective.booking.repository.RoomRepository
import ru.effective.booking.repository.RoomRepositoryImpl

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RoomRepository =
        RoomRepositoryImpl(AppDb.getInstance(context = application).roomDao())

    val data: LiveData<RoomModel> = repository.data
        .map(::RoomModel)
        .asLiveData(Dispatchers.Default)


    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        repository.getRoom()
    }
}