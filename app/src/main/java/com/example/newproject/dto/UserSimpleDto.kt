package com.example.newproject.dto

import com.example.newproject.model.domain.User

class UserSimpleDto(val username: String) {
    companion object {
        fun fromEntity(entity: User): UserSimpleDto {
            return UserSimpleDto(entity.getUsername())
        }
    }
}