package com.tispunshahryar960103.onlineshop.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageBinding {



    @BindingAdapter("image")
    @JvmStatic
    fun getImage(iamgeView:ImageView,url:String){

        Glide.with(iamgeView).load(url).into(iamgeView)

    }


}