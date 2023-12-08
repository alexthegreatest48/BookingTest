package ru.effective.booking.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.effective.booking.R
import ru.effective.booking.adapter.BookAdapter
import ru.effective.booking.databinding.BookCardBinding
import ru.effective.booking.viewmodel.BookViewModel

class BookFragment: Fragment() {
    private val viewModel:BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = BookCardBinding.inflate(inflater, container, false)
        val adapter = BookAdapter()

        binding.fab.setOnClickListener {
            if(binding.nameT.length() > 1 ||
                binding.surname.length() > 1 ||
                binding.dateBirth.length() > 1 ||
                binding.countryPass.length() > 1 ||
                binding.passNum.length() > 1) findNavController().navigate(R.id.action_bookFragment_to_finFragment)
            else {
                Toast.makeText(context, "Не все данные заполнены", Toast.LENGTH_LONG)
                    .show()
            }
        }

        viewModel.data.observe(viewLifecycleOwner) { state ->
            with(binding){
                rating.text = state.book[0].rating.toString()
                name.text = state.book[0].name
                adress.text = state.book[0].adress
                departure.text = state.book[0].departure
                arrival.text = state.book[0].arrivalCountry
                date.text = state.book[0].dateStart + '-' + state.book[0].dateEnd
                night.text = state.book[0].nights.toString()
                hotel.text = state.book[0].name
                room.text = state.book[0].room
                food.text = state.book[0].nutrition
            }
            adapter.submitList(state.book)
        }

        return binding.root
    }
}