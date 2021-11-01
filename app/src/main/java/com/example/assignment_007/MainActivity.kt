package com.example.assignment_007

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.assignment_007.home.HomeFragment
import com.example.assignment_007.register.RegisterFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val viewModelFactory = MainActivityViewModelFactory(context = applicationContext)
        var viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityModel::class.java)


        viewModel.readToken.observe(this, {token ->
            Log.d("token", "token is $token")

            if (token == "QpwL5tke4Pnpja7X4") {

                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fragment_container_view, HomeFragment())
                ft.commit()
            }


        })







        //


        /* val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
         ft.replace(R.id.fragment_container_view, HomeFragment())
         ft.commit()*/
    }

    private fun ft() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container_view, HomeFragment())
        // ft.addToBackStack(null)
        ft.commit()
    }


}