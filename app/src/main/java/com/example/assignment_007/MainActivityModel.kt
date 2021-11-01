package com.example.assignment_007

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map

class MainActivityModel(val context: Context) : ViewModel() {
//class MainActivityModel(application: Application): AndroidViewModel(application){


    val readToken = context.tokenStore.data.map {
        it[tokenKey]
    }.asLiveData()


    /*  private fun showToken(){
          requireContext().tokenStore.data.map {
              it[tokenKey] ?:"empty key"
          }.asLiveData().observe(viewLifecycleOwner,{
              binding.tvInfo.text = it
          })
      }*/


}