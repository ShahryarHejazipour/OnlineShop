package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.FragmentLoginBinding
import com.tispunshahryar960103.onlineshop.databinding.FragmentPostBinding
import com.tispunshahryar960103.onlineshop.repository.Repository
import com.tispunshahryar960103.onlineshop.view.adapter.Adapter_Post
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_fragment_Post
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_login
import kotlinx.android.synthetic.main.fragment_post.*

class LoginFragment : Fragment() {

    var binding : FragmentLoginBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        var viewModel = ViewModelProvider(this).get(ViewModel_login::class.java)

        binding!!.data=viewModel

        viewModel.mutableLiveData.observe(requireActivity(), Observer {
            
            if (it.status.equals("ok")){

                Toast.makeText(requireContext(), "OK", Toast.LENGTH_SHORT).show()
                Repository.sharedWrite(requireActivity(),it.user_id)

                
            }else{
                Toast.makeText(requireActivity(), "نام کاربری یا رمز عبور درست نیست!!", Toast.LENGTH_SHORT).show()
            }



        })

        viewModel.mutable_check_intent.observe(requireActivity(), Observer {



        })

        return binding!!.root
        }


    }


