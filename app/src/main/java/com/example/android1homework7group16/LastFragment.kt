package com.example.android1homework7group16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android1homework7group16.databinding.FragmentLastBinding

class LastFragment : Fragment() {
    private var _binding: FragmentLastBinding? = null
    private val binding: FragmentLastBinding get() = _binding!!
    private val CarsListAdapter = CarsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillCarsList()
        setupRecycleView()
    }

    private fun fillCarsList() {
        val carsList = listOf(
            Cars(R.drawable.img1, "БМВ", "V2", 4),
            Cars(R.drawable.img2, "Волга", "1.2:Цил", 4),
            Cars(R.drawable.img3, "Лада", "1.3:Цил", 4),
            Cars(R.drawable.img4, "Мустанг", "V4", 4),
            Cars(R.drawable.img1, "БМВ", "V2", 4),
            Cars(R.drawable.img3, "Лада", "1.3:Цил", 4),
            Cars(R.drawable.img2, "Волга", "1.2:Цил", 4),
            Cars(R.drawable.img4, "Мустанг", "V6", 4),
        )
        CarsListAdapter.setData(carsList)
    }

    private fun setupRecycleView() {
        binding.rvCars.adapter = CarsListAdapter
    }

}