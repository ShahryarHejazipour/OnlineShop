package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_fragment_Post


class PostFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var viewModel=ViewModelProvider(this).get(ViewModel_fragment_Post::class.java)
        viewModel.listPost()
        viewModel.mutableLiveData.observe(requireActivity(), Observer {

            Log.e("ListPost",it.toString())
        })


        super.onViewCreated(view, savedInstanceState)
    }
}