package com.example.newproject.model.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TodoRepository {
    private val database: FirebaseDatabase = Firebase.database("https://oop-6184c-default-rtdb.firebaseio.com/")
    private val todoReference: DatabaseReference = database.getReference("todos")
}