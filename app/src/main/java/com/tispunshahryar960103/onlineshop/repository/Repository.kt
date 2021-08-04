package com.tispunshahryar960103.onlineshop.repository

import android.content.Context
import retrofit2.Response
import java.lang.Exception

abstract class Repository {

     suspend fun <T:Any> customRequest(Api:()-> Response<T>) :T{

         val response = Api.invoke()

         if (response.isSuccessful) return response.body()!!
         throw Exception(response.message())


     }


  companion object{
      fun sharedWrite(context:Context,userId:String){

          val sh = context.getSharedPreferences("token",0)
          var editor=sh.edit()
          editor.putString("userId",userId)
          editor.commit()

      }


      fun sharedRead(context:Context,userId:String):String{

          val sh = context.getSharedPreferences("token",0)
          var userId: String? =sh.getString("userId",null)

          return userId!!

      }
  }

}