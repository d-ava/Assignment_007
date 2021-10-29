package com.example.assignment_007.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentLoginBinding
import com.example.assignment_007.databinding.FragmentRegisterBinding
import com.example.assignment_007.network.NetworkClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterModel>(FragmentRegisterBinding::inflate) {

    override fun getViewModel() = RegisterModel::class.java

    override var useSharedViewModel = false

    override fun start() {
        setListeners()
    }


    private fun setListeners() {
        binding.btnRegister.setOnClickListener {


            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()


            viewModel.goUserRegister(email = email, password = password, repeatPassword = password)

            viewModel.userRegister.observe(viewLifecycleOwner, {

                val token = it.body()?.token ?: "empty token"

                Log.d("---", "the fucking token is $token")


            })

            //findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}