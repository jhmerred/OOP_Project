package com.example.newproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newproject.R
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.newproject.R.*

class HomeFragment : Fragment() {
    private lateinit var logoutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // 로그아웃 버튼
        logoutButton = view.findViewById(R.id.logoutButton)
        logoutButton.setOnClickListener {
            // 로그아웃 기능 구현
        }

        // 이름과 학과 표시
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val departmentTextView = view.findViewById<TextView>(R.id.departmentTextView)
        nameTextView.text = "이름"
        departmentTextView.text = "학과"

        // 우선순위 목록 창
        val priorityListLayout = view.findViewById<LinearLayout>(R.id.priorityListLayout)
        val addButtonPriority = Button(requireContext())
        addButtonPriority.text = "+"
        addButtonPriority.setOnClickListener {
            // 우선순위 추가 기능 구현
        }
        priorityListLayout.addView(addButtonPriority)

        // 오늘 할 일 목록 창
        val todoListLayout = view.findViewById<LinearLayout>(R.id.todoListLayout)
        val addButtonTodo = Button(requireContext())
        addButtonTodo.text = "+"
        addButtonTodo.setOnClickListener {
            // 할 일 추가 기능 구현
        }
        todoListLayout.addView(addButtonTodo)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
