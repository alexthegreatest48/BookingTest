package ru.effective.booking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.effective.booking.databinding.RoomCardBinding
import ru.effective.booking.dto.Room
import ru.effective.booking.view.load

class RoomAdapter() : ListAdapter<Room, RoomViewHolder>(RoomViewHolder.RoomDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = RoomCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = getItem(position)
        holder.bind(room)
    }
}

class RoomViewHolder(
    private val binding: RoomCardBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(room: Room) {
        binding.apply {
            photo.load(room.image)
            name.text = room.name
            price.text = room.price.toString()
            pricePer.text = room.pricePer
        }
    }


    class RoomDiffCallback : DiffUtil.ItemCallback<Room>() {
        override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
            return oldItem == newItem
        }
    }
}