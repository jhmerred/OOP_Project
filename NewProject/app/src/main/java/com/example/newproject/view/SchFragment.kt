package com.example.newproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import com.example.newproject.R
import com.example.newproject.databinding.FragmentSchBinding

class SchFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentSchBinding.inflate(inflater, container, false)
        val calendarView: CalendarView = binding.calendarView
        calendarView.date = System.currentTimeMillis()
        // Inflate the layout for this fragment

        binding.addEventButton.setOnClickListener {

        }
        return inflater.inflate(R.layout.fragment_sch, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}