package ru.effective.booking.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.effective.booking.R
import ru.effective.booking.adapter.HotelAdapter
import ru.effective.booking.databinding.HotelCardBinding
import ru.effective.booking.view.load
import ru.effective.booking.viewmodel.HotelViewModel


class HotelFragment : Fragment() {
    private val viewModel: HotelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = HotelCardBinding.inflate(inflater, container, false)
        val adapter = HotelAdapter()




        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_hotelFragment_to_roomFragment)
        }



        viewModel.data.observe(viewLifecycleOwner) { state ->
            with(binding){
                photo.load(state.hotel[0].image[0])
                rating.text = state.hotel[0].rating.toString()
                name.text = state.hotel[0].name
                adress.text = state.hotel[0].adress
                price.text = state.hotel[0].minimalPrice.toString()
                priceText.text = state.hotel[0].priceForIt
                description.text = state.hotel[0].about.description
            }
            adapter.submitList(state.hotel)
        }

        return binding.root
    }
}