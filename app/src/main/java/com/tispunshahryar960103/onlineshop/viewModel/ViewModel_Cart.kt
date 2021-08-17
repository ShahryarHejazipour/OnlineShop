package com.tispunshahryar960103.onlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tispunshahryar960103.onlineshop.model.Model_ListCart
import com.tispunshahryar960103.onlineshop.model.Model_ListOrder
import com.tispunshahryar960103.onlineshop.model.Model_UserInfo
import com.tispunshahryar960103.onlineshop.model.Price
import com.tispunshahryar960103.onlineshop.repository.Api
import com.tispunshahryar960103.onlineshop.repository.Handle_Request
import com.tispunshahryar960103.onlineshop.repository.ThreadMain
import kotlinx.coroutines.Job

class ViewModel_Cart: ViewModel() {


    lateinit var job:Job
    val mutable_CartList=MutableLiveData<List<Model_ListCart>>()
    val mutable_Price_All=MutableLiveData<Price>()


    fun listPost(user:String){

        job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().post_ListCart(user))},{
            mutable_CartList.value=it})


        job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().post_Price_All(user))},{
            mutable_Price_All.value=it})




    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}