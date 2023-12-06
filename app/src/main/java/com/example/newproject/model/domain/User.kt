package com.example.newproject.model.domain

class User(
    private val name: String,
    private val username: String,
    private val password: String,
    private val friendList: ArrayList<String> = arrayListOf<String>(),
    private val todoList: ArrayList<Todo> = arrayListOf<Todo>(),
    private val profileImage: String = ""   // 프사 uri
) {
    fun getUsername(): String {
        return this.username
    }

    fun getFriendList(): ArrayList<String> {
        return this.friendList
    }
}