package com.example.assignment_007.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_007.model.User
import com.example.assignment_007.network.NetworkClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginModel:ViewModel() {



    private val _login = MutableLiveData<User>()
    val login:LiveData<User> get()=_login



    fun login(){


    }




}