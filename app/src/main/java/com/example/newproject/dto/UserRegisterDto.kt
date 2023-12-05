package com.example.newproject.dto

import com.example.newproject.model.domain.User

class UserRegisterDto(private val name: String, private val username: String, private val password: String, private val profileImg: String = "") {
    fun toEntity(): User {
        return User(this.name, this.username, this.password, profileImage = this.profileImg)
    }
}