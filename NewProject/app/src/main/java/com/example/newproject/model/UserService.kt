package com.example.newproject.model

import com.example.newproject.dto.UserRegisterDto
import com.example.newproject.model.repository.UserRepository

class UserService() {

    private val userRepository: UserRepository = UserRepository()

    fun addUser(userDto: UserRegisterDto) {
        val user = userDto.toEntity()

        userRepository.saveUser(user)
    }

    fun findAllUser() {

    }
//
//    fun addTodo(toDo: Todo){
//        // TODO: 해당 유저의 todo-list에 할 일을 추가한다
//        user: User = userRef.
//
//        user.todoList.add(toDo)
//    }
//
//    fun addFriend(friend: User){
//        // TODO: 해당 유저의 친구 리스트에 파라미터로 받은 사용자를 추가한다
//
//        user.friendList.add(friend)
//    }
//
//    fun changeUserProfileImage(img: String) {
//        // TODO: 이미지 URI 받아서 해당 유저의 프로필 사진을 바꾼다
//
//        user.profileImage = img
//
//    }
}