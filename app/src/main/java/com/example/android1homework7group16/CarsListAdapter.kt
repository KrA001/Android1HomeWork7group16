package com.example.android1homework7group16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android1homework7group16.databinding.CarsItemBinding

class CarsListAdapter : RecyclerView.Adapter<CarsListAdapter.AnimalViewHolder>() {
    private var carss = listOf<Cars>()

    fun setData(data: List<Cars>) {
        carss = data
    }

    class AnimalViewHolder(private val binding: CarsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(cars: Cars) = with(binding) {
            ivGaller.setImageResource(cars.carsImage)
            tvText.text = cars.name
            tvWool.text = cars.engine
            tvEars.text = cars.wheels.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = CarsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return carss.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.onBind(carss[position])
    }
}