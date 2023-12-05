package com.example.newproject.model

data class Friend(val name: String, val profileImage: String)

class FriendManager {
    private val friendList = mutableListOf<Friend>()

    fun addFriend(friend: Friend) {
        friendList.add(friend)
    }

    fun getFriends(): List<Friend> {
        return friendList
    }
}