package com.tispunshahryar960103.onlineshop.repository

import retrofit2.Response

object Handle_Request :Repository() {

    suspend fun <T:Any> response(Api:Response<T>)=customRequest{

        Api

    }

}