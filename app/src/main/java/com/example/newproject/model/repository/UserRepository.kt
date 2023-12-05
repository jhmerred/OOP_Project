package com.example.newproject.model.repository

import android.util.Log
import com.example.newproject.model.domain.User
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserRepository {
    private val database: FirebaseDatabase = Firebase.database("https://oop-6184c-default-rtdb.firebaseio.com/")
    private val userRef = database.getReference("users")

    fun saveUser(user: User) {
        userRef.child(user.username).get()
            .addOnSuccessListener {
                Log.e("System", "이미 존재하는 아이디입니다. 다시 시도해주세요.")
            }
            .addOnFailureListener {
                userRef.child(user.username).setValue(user)
            }
    }

    fun updateUser(user: User) {
        userRef.child(user.username).get()
            .addOnSuccessListener {
                userRef.child(user.username).setValue(user)
            }
            .addOnFailureListener {
                Log.e("System", "존재하지 않는 아이디입니다. 다시 시도해주세요.")
            }
    }
}