package com.tispunshahryar960103.onlineshop.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.ItemspostBinding
import com.tispunshahryar960103.onlineshop.model.Model_Post

class Adapter_Post(val listpost: List<Model_Post>) :
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

       // holder.binding.txtPrice.setText(modelPost.price)
        holder.binding.txtPrice.text=modelPost.price + " تومان "
       // Glide.get().

    }

    override fun getItemCount(): Int {

        return listpost.size
    }


    class viewHolder(val binding: ItemspostBinding) : RecyclerView.ViewHolder(binding.root) {


    }
}