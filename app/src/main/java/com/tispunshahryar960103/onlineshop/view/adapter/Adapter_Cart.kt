package com.tispunshahryar960103.onlineshop.view.adapter

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE

import android.view.ViewGroup
import androidx.constraintlayout.solver.widgets.ConstraintWidget.GONE
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.ItemscartBinding
import com.tispunshahryar960103.onlineshop.databinding.ItemsorderBinding
import com.tispunshahryar960103.onlineshop.model.Model_ListCart
import com.tispunshahryar960103.onlineshop.model.Model_ListOrder
import com.tispunshahryar960103.onlineshop.repository.Api
import com.tispunshahryar960103.onlineshop.repository.Handle_Request
import com.tispunshahryar960103.onlineshop.repository.ThreadMain
import kotlinx.coroutines.Job

class Adapter_Cart(
    val context: Context,
    val userid:String,
    val listpost: List<Model_ListCart>,
    val change: changePrice
) :
    RecyclerView.Adapter<Adapter_Cart.viewHolder>() {

    lateinit var job: Job


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        return viewHolder(

            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.itemscart,
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val data: Model_ListCart = listpost[position]
        holder.binding.data = data

        holder.binding.ImAdd.setOnClickListener {


            job = ThreadMain.Coroutines_Handle({
                Handle_Request.response(
                    Api.invoke().Post_AddCart(data.idproduct,userid,"1","add")
                )
            },
                {

                    change.changeCount()

                })


        }

        holder.binding.ImMines.setOnClickListener {


            job = ThreadMain.Coroutines_Handle({
                Handle_Request.response(
                    Api.invoke().Post_AddCart(data.idproduct,userid,"1","m")
                )
            },
                {

                    change.changeCount()

                })


        }

        holder.binding.BtnDel.setOnClickListener {


        }


    }

    override fun getItemCount(): Int {

        return listpost.size
    }


    interface changePrice {

        fun changeCount()
    }


    class viewHolder(val binding: ItemscartBinding) : RecyclerView.ViewHolder(binding.root)
}