package com.tispunshahryar960103.onlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tispunshahryar960103.onlineshop.model.Model_ListOrder
import com.tispunshahryar960103.onlineshop.model.Model_UserInfo
import com.tispunshahryar960103.onlineshop.repository.Api
import com.tispunshahryar960103.onlineshop.repository.Handle_Request
import com.tispunshahryar960103.onlineshop.repository.ThreadMain
import kotlinx.coroutines.Job

class ViewModel_profile: ViewModel() {


    lateinit var job:Job
    val mutable_userInfo=MutableLiveData<List<Model_UserInfo>>()
    val mutable_listOrder=MutableLiveData<List<Model_ListOrder>>()


    fun listPost(user:String){

        job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().post_userInfo(user))},{
            mutable_userInfo.value=it})


        job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().post_ListOrder(user))},{
            mutable_listOrder.value=it})




    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}