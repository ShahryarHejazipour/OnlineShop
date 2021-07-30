package com.tispunshahryar960103.onlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tispunshahryar960103.onlineshop.model.Model_Post
import com.tispunshahryar960103.onlineshop.repository.Api
import com.tispunshahryar960103.onlineshop.repository.Handle_Request
import com.tispunshahryar960103.onlineshop.repository.ThreadMain
import kotlinx.coroutines.Job

class ViewModel_fragment_Post: ViewModel() {


    lateinit var job:Job
    val mutableLiveData=MutableLiveData<List<Model_Post>>()


    fun listPost(){

        job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().listPost())},{
            mutableLiveData.value=it})

    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}