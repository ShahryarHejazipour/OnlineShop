package com.tispunshahryar960103.onlineshop.view.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.ItemspostBinding
import com.tispunshahryar960103.onlineshop.model.Model_Post

class Adapter_Post(val listpost: List<Model_Post>,val itemsClick:ClickItems) :
    RecyclerView.Adapter<Adapter_Post.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        return viewHolder(

            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.itemspost,
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val modelPost: Model_Post = listpost[position]
        holder.binding.post = modelPost
        holder.binding.txtPrice.text=modelPost.price + " تومان "    // holder.binding.txtPrice.setText(modelPost.price)
        holder.itemView.setOnClickListener(){
            itemsClick.itemID(modelPost.id)
        }



    }

    override fun getItemCount(): Int {

        return listpost.size
    }


    interface ClickItems{

        fun itemID(id:String)
    }


    class viewHolder(val binding: ItemspostBinding) : RecyclerView.ViewHolder(binding.root)
}