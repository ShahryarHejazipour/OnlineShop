package com.tispunshahryar960103.onlineshop.repository

import com.tispunshahryar960103.onlineshop.model.*
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

    @FormUrlEncoded
    @POST("login.php")
    suspend fun postLogin(@Field("mobile")mobile:String,@Field("pass")pass:String):Response<Model_Status>


    @FormUrlEncoded
    @POST("User_info.php")
    suspend fun post_userInfo(@Field("user_id")userid:String):Response<List<Model_UserInfo>>


    @FormUrlEncoded
    @POST("list_order.php")
    suspend fun post_ListOrder(@Field("user")user:String):Response<List<Model_ListOrder>>



    @FormUrlEncoded
    @POST("Reg.php")
    suspend fun postRegister(@Field("name")name:String,
                          @Field("mobile")mobile:String,
                          @Field("email")email:String,
                          @Field("pass")pass:String):Response<Model_Status>





    companion object{

        operator fun invoke() : Api{

            return Retrofit.Builder()
                .baseUrl("http://192.168.1.85/shop/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api::class.java)
        }
    }
}