package com.tispunshahryar960103.onlineshop.view.activity


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView

import com.tispunshahryar960103.onlineshop.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var navController: NavController
    lateinit var appBar: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        appBar = AppBarConfiguration.Builder(R.navigation.navigation).build()

        navController = Navigation.findNavController(this, R.id.fragment)

        NavigationUI.setupActionBarWithNavController(this, navController, appBar)

        NavigationUI.setupWithNavController(bottom_Navigation, navController)

        bottom_Navigation.setOnItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_shop_home -> {
                navController.navigate(R.id.postFragment)
            txt_title.text="فروشگاه"

            }
            R.id.menu_profile -> {
                navController.navigate(R.id.profileFragment)
            txt_title.text="پروفایل"
            }
            R.id.menu_cart -> {
                navController.navigate(R.id.cartFragment)
            txt_title.text="سبد خرید"

            }


        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }

}


