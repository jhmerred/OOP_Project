package com.example.newproject.model.repository

import android.util.Log
import com.example.newproject.dto.UserUpdateDto
import com.example.newproject.model.domain.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Singleton
class UserRepository {
    /***
     * Repository는 단 한번만 생성되면 됨.
     * 따라서, 불 필요한 객체 생성 방지를 위해 싱글톤 패턴을 사용하여
     * 애플리케이션에서 단 한 번만 생성하도록 함
     */

    private val database: FirebaseDatabase = Firebase.database("https://oop-6184c-default-rtdb.firebaseio.com/")
    private val userRef = database.getReference("users")

    fun saveUser(user: User) {
        userRef.child(user.getUsername()).get()
            .addOnSuccessListener {
                Log.e("System", "이미 존재하는 아이디입니다. 다시 시도해주세요.")
            }
            .addOnFailureListener {
                userRef.child(user.getUsername()).setValue(user)
            }
    }

    suspend fun findUserById(username: String): User? = suspendCoroutine { continuation ->
        val query: Query = userRef.orderByChild("username").equalTo(username)

        query.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for(userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(User::class.java)
                        continuation.resume(user)
                        return
                    }
                }
                continuation.resume(null)
            }

            override fun onCancelled(error: DatabaseError) {
                continuation.resume(null)
            }
        })
    }

    fun updateUser(username: String, dto: UserUpdateDto) {
        val map = dto.toMap()

        userRef.child("username").updateChildren(map)
    }
}