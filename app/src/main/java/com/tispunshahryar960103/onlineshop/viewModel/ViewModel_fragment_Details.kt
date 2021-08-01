package com.tispunshahryar960103.onlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tispunshahryar960103.onlineshop.model.Model_Post
import com.tispunshahryar960103.onlineshop.model.PostDetails
import com.tispunshahryar960103.onlineshop.repository.Api
import com.tispunshahryar960103.onlineshop.repository.Handle_Request
import com.tispunshahryar960103.onlineshop.repository.ThreadMain
import kotlinx.coroutines.Job

class ViewModel_fragment_Details: ViewModel() {


    lateinit var job:Job
    val mutableLiveData=MutableLiveData<PostDetails>()


    fun listPost(id:String){

        job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().postdetailes(id))},{
            mutableLiveData.value=it})

    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}