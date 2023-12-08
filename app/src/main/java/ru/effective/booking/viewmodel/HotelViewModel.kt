package ru.effective.booking.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.effective.booking.db.AppDb
import ru.effective.booking.model.HotelModel
import ru.effective.booking.model.HotelModelState
import ru.effective.booking.repository.HotelRepository
import ru.effective.booking.repository.HotelRepositoryImpl

class HotelViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: HotelRepository =
        HotelRepositoryImpl(AppDb.getInstance(context = application).hotelDao())

    val data: LiveData<HotelModel> = repository.data
        .map(::HotelModel)
        .asLiveData(Dispatchers.Default)
    private val _dataState = MutableLiveData<HotelModelState>()




    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        _dataState.value = HotelModelState(loading = true)
        repository.getHotel()
        _dataState.value = HotelModelState()
    }
}
