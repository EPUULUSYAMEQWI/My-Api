package com.example.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts():Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostsbyId(@Path("id")postId:Int):Call<Post>
}