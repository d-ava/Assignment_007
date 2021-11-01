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
import retrofit2.Response

class LoginModel : ViewModel() {


    private val _userLogin = MutableLiveData<Response<User>>()
    val userLogin: LiveData<Response<User>> get() = _userLogin



    fun goUserLogin(email: String, password: String) {
        viewModelScope.launch {
            withContext(IO) {
                val response = NetworkClient.api.userLogin(email=email,password= password)
                val body = response.body()
                if(response.isSuccessful && body != null){
                    _userLogin.postValue(response)
                }

            }
        }
    }

}