package com.example.newproject.model.domain

class User(
    val name: String,
    val username: String,
    val password: String,
    val friendList: ArrayList<String> = arrayListOf<String>(),
    val todoList: ArrayList<Todo> = arrayListOf<Todo>(),
    val profileImage: String = ""   // 프사 uri
)