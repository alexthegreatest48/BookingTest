package ru.effective.booking.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.effective.booking.R
import ru.effective.booking.databinding.BookCardBinding
import ru.effective.booking.databinding.FinCardBinding

class FinFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FinCardBinding.inflate(inflater, container, false)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_finFragment_to_hotelFragment)
        }
        return binding.root
    }
}