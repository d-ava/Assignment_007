package com.example.assignment_007.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_007.model.User
import com.example.assignment_007.network.NetworkClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class RegisterModel : ViewModel() {

    private val _userRegister = MutableLiveData<Response<User>>()
    val userRegister: LiveData<Response<User>> get() = _userRegister



    fun goUserRegister(email: String, password: String, repeatPassword: String) {
        viewModelScope.launch {
                withContext(IO){
                    try {
                        val response = NetworkClient.api.userRegister(email, password)
                        val body = response.body()
                        if (response.isSuccessful && body != null){
                            _userRegister.postValue(response)
                        }

                    }catch (e:Exception){
                        Log.e("---", "${ e.message }")
                    }
                }
        }
    }


  /*  private val _userRegisterFlow = MutableStateFlow<Response<User>>()
    val userRegisterFlow = _userRegisterFlow.asStateFlow()

    fun goUserRegisterFlow(email: String, password: String){
        viewModelScope.launch {
            withContext(IO){
                val response = NetworkClient.api.userRegister(email=email, password=password)
                val body = response.body()
                if (response.isSuccessful && body != null){
                    _userRegisterFlow.value = response
                }
            }
        }
    }
*/

}