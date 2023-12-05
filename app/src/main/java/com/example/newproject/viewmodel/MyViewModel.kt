package com.example.newproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MyViewModel(application: Application):AndroidViewModel(application){
    val myText: MutableLiveData<String> =MutableLiveData()
    fun updateText(newText:String){
        myText.value=newText
    }

}