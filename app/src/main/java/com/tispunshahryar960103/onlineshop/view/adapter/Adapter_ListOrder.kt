package com.tispunshahryar960103.onlineshop.view.adapter

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
import com.tispunshahryar960103.onlineshop.databinding.ItemsorderBinding
import com.tispunshahryar960103.onlineshop.model.Model_ListOrder

class Adapter_ListOrder(val listpost: List<Model_ListOrder>) :
    RecyclerView.Adapter<Adapter_ListOrder.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        return viewHolder(

            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.itemsorder,
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val data: Model_ListOrder = listpost[position]
        holder.binding.data=data

        when(data.status){

            "1" -> {
                holder.binding.LinerSuccess.visibility= View.VISIBLE
                holder.binding.LinerNotprice.visibility= View.GONE
            }
            else -> {
                holder.binding.LinerNotprice.visibility= View.VISIBLE
                holder.binding.LinerSuccess.visibility= View.GONE

            }

        }





    }

    override fun getItemCount(): Int {

        return listpost.size
    }


    interface ClickItems{

        fun itemID(id:String)
    }


    class viewHolder(val binding: ItemsorderBinding) : RecyclerView.ViewHolder(binding.root)
}