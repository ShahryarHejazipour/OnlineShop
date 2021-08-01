package com.tispunshahryar960103.onlineshop.repository

import com.tispunshahryar960103.onlineshop.model.Model_Post
import com.tispunshahryar960103.onlineshop.model.Post
import com.tispunshahryar960103.onlineshop.model.PostDetails
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("index.php")
    suspend fun listPost(): Response<List<Model_Post>>

    @FormUrlEncoded
    @POST("postdetails.php")
    suspend fun postdetailes(@Field("id")id:String):Response<PostDetails>



    companion object{

        operator fun invoke() : Api{

            return Retrofit.Builder()
                .baseUrl("http://192.168.1.85/shop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api::class.java)
        }
    }
}