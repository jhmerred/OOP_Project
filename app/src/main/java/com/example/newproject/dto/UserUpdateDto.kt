package com.example.newproject.dto

import com.example.newproject.model.domain.User

class UserUpdateDto(private val username: String, private val name: String, private val friendList: ArrayList<String>, val userProfileImage: String) {

}