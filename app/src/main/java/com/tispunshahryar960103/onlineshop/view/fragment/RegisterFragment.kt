package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.FragmentRegisterBinding
import com.tispunshahryar960103.onlineshop.repository.Repository
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_register

class RegisterFragment : Fragment() {

    var binding:FragmentRegisterBinding?=null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRegisterBinding.inflate(inflater,container,false)

        var viewModel=ViewModelProvider(requireActivity()).get(ViewModel_register::class.java)

        binding!!.data=viewModel

        viewModel.mutable_check_intent.observe(requireActivity(), Observer {



        })

        viewModel.mutableLiveData.observe(requireActivity(), Observer {

            if (it.status.equals("ok")){
                Toast.makeText(requireActivity(), "OK", Toast.LENGTH_SHORT).show()
                Repository.sharedWrite(requireActivity(),it.user_id)

            }else{
                Toast.makeText(requireActivity(), "خطا در ذخیره ی اطلاعات...!!", Toast.LENGTH_SHORT).show()


            }
        })



        return binding!!.root
    }




}