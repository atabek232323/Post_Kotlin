package com.example.post_kotlin.repazitori

import com.example.post_kotlin.data.remote.PostInstance
import com.example.post_kotlin.model.Post
import retrofit2.Retrofit

class Repazitori {
    suspend fun getPosts(): List<Post> {
        return PostInstance.api.getPosts()

    }
}