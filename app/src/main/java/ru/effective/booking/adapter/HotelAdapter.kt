package ru.effective.booking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.effective.booking.R
import ru.effective.booking.databinding.HotelCardBinding
import ru.effective.booking.dto.Hotel
import ru.effective.booking.view.load

class HotelAdapter() : ListAdapter<Hotel, HotelViewHolder>(HotelDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val binding = HotelCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = getItem(position)
        holder.bind(hotel)
    }
}

class HotelViewHolder(
    private val binding: HotelCardBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hotel: Hotel) {
        binding.apply {
            photo.load(hotel.image[0])
            rating.text = hotel.rating.toString()
            name.text = hotel.name
            adress.text = hotel.adress
            price.text = hotel.minimalPrice.toString()
            priceText.text = hotel.priceForIt
            description.text = hotel.about.description
        }
    }
}

class HotelDiffCallback : DiffUtil.ItemCallback<Hotel>() {
    override fun areItemsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem == newItem
    }
}