package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.view.adapter.Adapter_Post
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_fragment_Post
import kotlinx.android.synthetic.main.fragment_post.*


class PostFragment : Fragment(), Adapter_Post.ClickItems {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)

        var viewModel = ViewModelProvider(this).get(ViewModel_fragment_Post::class.java)
        viewModel.listPost()
        viewModel.mutableLiveData.observe(requireActivity(), Observer { itpost ->

            recyclerView.also {

                it.layoutManager =
                    LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                val adapter = Adapter_Post(itpost,this)
                it.adapter = adapter

            }


            // recyclerView.adapter=Adapter_Post(it)


        })


    }

    override fun itemID(id: String) {

        val bundle= Bundle()
        bundle.putString("idPost",id)
        Navigation.findNavController(recyclerView).navigate(R.id.action_postFragment_to_detailsFragment,bundle)



    }
}