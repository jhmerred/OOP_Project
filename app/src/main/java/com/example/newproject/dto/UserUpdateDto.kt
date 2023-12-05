package com.example.newproject.dto

import com.example.newproject.model.domain.User

class UserUpdateDto(
    private val username: String? = null,
    private val name: String? = null,
    private val friendList: ArrayList<String>? = null,
    private val profileImage: String? = null
) {
    fun toMap(): Map<String, Any> {
        val map = mutableMapOf<String, Any>()

        username?.let { map["username"] = it }
        name?.let { map["name"] = it }
        friendList?.let { map["friendList"] = it }
        profileImage?.let { map["profileImage"] = it }

        return map
    }
}