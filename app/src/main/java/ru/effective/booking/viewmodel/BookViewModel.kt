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
import ru.effective.booking.model.BookModel
import ru.effective.booking.repository.BookRepository
import ru.effective.booking.repository.BookRepositoryImpl

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BookRepository =
        BookRepositoryImpl(AppDb.getInstance(context = application).bookDao())

    val data: LiveData<BookModel> = repository.data
        .map(::BookModel)
        .asLiveData(Dispatchers.Default)


    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {
        repository.getBook()
    }
}