package ru.effective.booking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.effective.booking.databinding.BookCardBinding
import ru.effective.booking.dto.Book

class BookAdapter() : ListAdapter<Book, BookViewHolder>(BookViewHolder.BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        holder.bind(book)
    }
}

class BookViewHolder(
    private val binding: BookCardBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Book) {
        binding.apply {
            rating.text = book.rating.toString()
            name.text = book.name
            adress.text = book.adress
            departure.text = book.departure
            arrival.text = book.arrivalCountry
            date.text = book.dateStart + '-' + book.dateEnd
            night.text = book.nights.toString()
            hotel.text = book.name
            room.text = book.room
            food.text = book.nutrition
        }
    }


    class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }
}