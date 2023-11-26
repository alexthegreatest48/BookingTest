package ru.effective.booking.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.effective.booking.R
import ru.effective.booking.adapter.RoomAdapter
import ru.effective.booking.databinding.RoomCardBinding
import ru.effective.booking.viewmodel.RoomViewModel

class RoomFragment: Fragment() {
    private val viewModel: RoomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = RoomCardBinding.inflate(inflater, container, false)
        val adapter = RoomAdapter()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_roomFragment_to_bookFragment)
        }

        viewModel.data.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.room)
        }

        return binding.root
    }
}