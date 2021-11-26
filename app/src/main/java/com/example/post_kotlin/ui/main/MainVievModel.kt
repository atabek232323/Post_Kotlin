package com.example.post_kotlin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.post_kotlin.model.Post
import com.example.post_kotlin.repazitori.Repazitori
import kotlinx.coroutines.launch

class MainVievModel(private val repazitori: Repazitori):ViewModel() {
    val myResponse:MutableLiveData<List<Post>> = MutableLiveData()

    fun getPosts(){
        viewModelScope.launch {
            val result = repazitori.getPosts()
            myResponse.value = result
        }
    }
}