package com.tispunshahryar960103.onlineshop.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.tispunshahryar960103.onlineshop.databinding.ItemsViewpagerBinding
import com.tispunshahryar960103.onlineshop.model.Slider

class ViewPager_Adapter(val list_strUrl:List<Slider>): PagerAdapter() {


    override fun getCount(): Int {
      return list_strUrl.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view==`object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       container.removeView(`object` as View)

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val binding=ItemsViewpagerBinding.inflate(LayoutInflater.from(container.context),container,false)

        binding.data= list_strUrl.get(position).image
        container.addView(binding.root)

        return binding.root
    }

    override fun getPageWidth(position: Int): Float {
        return 0.95f
    }
}