package com.example.post_kotlin.data.remote

import com.example.post_kotlin.model.Post
import retrofit2.http.GET

interface PostApi {
    @GET("posts")//https://jsonplaceholder.typicode.com/posts
   suspend fun getPosts():List<Post>
}