package com.example.android1homework7group16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.example.android1homework7group16.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!

   // private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCounterZer.text = Cars.count.toString()
        setupCount()
        savedInstanceState?.let {
            Cars.count = it.getInt(NUMBER, 0)
            binding.tvCounterZer.text = Cars.count.toString()
        }
    }

    private fun setupCount() = with(binding) {
        btnIncrement.setOnClickListener {
            if (Cars.count < 10) {
                Cars.count++
                tvCounterZer.text = Cars.count.toString()
            } else {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_view, LastFragment())
                    .addToBackStack("Last Fragment")
                    .commit()
            }
        }

        btnDecrement.setOnClickListener {
            if (Cars.count > 0) {
                Cars.count--
                tvCounterZer.text = Cars.count.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putInt(NUMBER, Cars.count)
        }
    }

    companion object {
        const val NUMBER = "count"
    }
}