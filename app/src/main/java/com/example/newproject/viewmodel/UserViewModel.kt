package com.example.newproject.viewmodel

import android.util.Log
import com.example.newproject.dto.UserRegisterDto
import com.example.newproject.dto.UserSimpleDto
import com.example.newproject.dto.UserUpdateDto
import com.example.newproject.model.repository.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) {
    fun addUser(userDto: UserRegisterDto) {
        val user = userDto.toEntity()

        userRepository.saveUser(user)
    }

    suspend fun findUserById(username: String): UserSimpleDto? {
        val byId = userRepository.findUserById(username)
        if(byId != null) {
            return UserSimpleDto.fromEntity(byId)
        } else {
            Log.e("System", "존재하지 않는 아이디입니다. 다시 시도해주세요.")

            return null
        }
    }
//
//    fun addTodo(toDo: Todo){
//        // TODO: 해당 유저의 todo-list에 할 일을 추가한다
//    }

    suspend fun updateFriendList(username: String, friendName: String) {
        val byId = userRepository.findUserById(username)
        if(byId == null) {
            Log.e("System", "존재하지 않는 아이디입니다.")
            return
        } else {
            val list = byId.getFriendList()
            list.add(friendName)

            val dto: UserUpdateDto = UserUpdateDto(friendList = list)

            userRepository.updateUser(username, dto)
        }
    }
}