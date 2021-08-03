package com.tispunshahryar960103.onlineshop.viewModel

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tispunshahryar960103.onlineshop.model.Model_Post
import com.tispunshahryar960103.onlineshop.model.Model_Status
import com.tispunshahryar960103.onlineshop.model.PostDetails
import com.tispunshahryar960103.onlineshop.repository.Api
import com.tispunshahryar960103.onlineshop.repository.Handle_Request
import com.tispunshahryar960103.onlineshop.repository.ThreadMain
import kotlinx.coroutines.Job

class ViewModel_login(val app:Application): AndroidViewModel(app) {


    lateinit var job:Job
    val mutableLiveData=MutableLiveData<Model_Status>()
    val mutable_check_intent=MutableLiveData<Boolean>()

    var mobile:String?=null
    var pass:String?=null


    fun clickBtn_login(view:View){

        if (mobile.isNullOrEmpty()){

            Toast.makeText(app.applicationContext, "شماره ی موبایل نادرست است...", Toast.LENGTH_SHORT).show()



        }else if (pass.isNullOrEmpty()){
            Toast.makeText(app.applicationContext, "پسورد نادرست است...", Toast.LENGTH_SHORT).show()


        }else

        {
            job=ThreadMain.Coroutines_Handle({Handle_Request.response(Api.invoke().postLogin(mobile!!,pass!!))},{
                mutableLiveData.value=it})
        }

    }

        fun clickBtn_intent_register(view:View){

            mutable_check_intent.value=true
        }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}