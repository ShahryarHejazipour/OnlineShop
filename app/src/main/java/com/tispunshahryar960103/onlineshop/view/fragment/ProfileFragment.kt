package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.FragmentLoginBinding
import com.tispunshahryar960103.onlineshop.databinding.FragmentProfileBinding
import com.tispunshahryar960103.onlineshop.model.Model_UserInfo
import com.tispunshahryar960103.onlineshop.repository.Repository
import com.tispunshahryar960103.onlineshop.view.adapter.Adapter_ListOrder
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_login
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_profile
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    var binding: FragmentProfileBinding? = null
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        var viewModel = ViewModelProvider(this).get(ViewModel_profile::class.java)
        navController = Navigation.findNavController(requireActivity(), R.id.fragment)
        val userId = Repository.sharedRead(requireActivity())
        viewModel.listPost(userId)



        viewModel.mutable_userInfo.observe(requireActivity(), Observer {

            val model=Model_UserInfo(it.get(0).email,it.get(0).mobile,it.get(0).name)
            binding!!.data = model

        })

        viewModel.mutable_listOrder.observe(requireActivity(), Observer {

            val adapter=Adapter_ListOrder(it)
            recyclerview.adapter=adapter
            recyclerview.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)

        })














        return binding!!.root
    }


}