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
import com.tispunshahryar960103.onlineshop.databinding.FragmentCartBinding
import com.tispunshahryar960103.onlineshop.databinding.FragmentProfileBinding
import com.tispunshahryar960103.onlineshop.repository.Repository
import com.tispunshahryar960103.onlineshop.view.adapter.Adapter_Cart
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_Cart
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_profile
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {
    var binding: FragmentCartBinding? = null
    lateinit var navController: NavController




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        var viewModel = ViewModelProvider(this).get(ViewModel_Cart::class.java)
        navController = Navigation.findNavController(requireActivity(), R.id.fragment)
        val userId = Repository.sharedRead(requireActivity())

        viewModel.listPost(userId)
        viewModel.mutable_Price_All.observe(requireActivity(), Observer {

            binding!!.TvPriceAll.text=it.price + "تومان"

        })

        viewModel.mutable_CartList.observe(requireActivity(), Observer {

            val adapter=Adapter_Cart(requireActivity(),userId,it,object:Adapter_Cart.changePrice{
                override fun changeCount() {


                    viewModel.listPost(userId)
                    viewModel.mutable_Price_All.observe(requireActivity(), Observer {

                        binding!!.TvPriceAll.text=it.price + "تومان"

                    })
                }


            })

            recyclerview.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)
            recyclerview.adapter=adapter






        })











        return binding!!.root
    }



}