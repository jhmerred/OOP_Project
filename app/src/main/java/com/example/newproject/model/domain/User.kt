package com.example.newproject.model.domain

class User(
    val name: String,
    val username: String,
    val password: String,
    var profileImage: String = ""   // 프사 uri
) {
    val todoList: ArrayList<Todo> = arrayListOf<Todo>()
    val friendList: ArrayList<User> = arrayListOf<User>()
}