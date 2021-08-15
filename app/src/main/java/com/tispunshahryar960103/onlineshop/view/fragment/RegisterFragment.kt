package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.FragmentRegisterBinding
import com.tispunshahryar960103.onlineshop.repository.Repository
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_register
import kotlinx.android.synthetic.main.fragment_post.*

class RegisterFragment : Fragment() {

    var binding:FragmentRegisterBinding?=null
    lateinit var navController:NavController




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRegisterBinding.inflate(inflater,container,false)
        navController=Navigation.findNavController(requireActivity(),R.id.fragment)
        val viewModel=ViewModelProvider(requireActivity()).get(ViewModel_register::class.java)

        binding!!.data=viewModel

        viewModel.mutable_check_intent.observe(requireActivity(), Observer {



        })

        viewModel.mutableLiveData.observe(requireActivity(), Observer {

            if (it.status.equals("ok")){
                Toast.makeText(requireActivity(), "OK", Toast.LENGTH_SHORT).show()
                Repository.sharedWrite(requireActivity(),it.user_id)
                navController.navigate(R.id.action_registerFragment_to_profileFragment)


            }else{
                Toast.makeText(requireActivity(), "خطا در ذخیره ی اطلاعات...!!", Toast.LENGTH_SHORT).show()


            }
        })

        viewModel.mutable_check_intent.observe(requireActivity(), Observer {
            navController.navigate(R.id.action_registerFragment_to_loginFragment)

        })



        return binding!!.root
    }




}