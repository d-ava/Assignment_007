package com.example.assignment_007.register

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.assignment_007.*
import com.example.assignment_007.databinding.FragmentRegisterBinding
import kotlinx.coroutines.launch

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

            viewModel.userRegister.observe(viewLifecycleOwner, { response ->

                val token = response.body()?.token ?: "empty token"

                viewLifecycleOwner.lifecycleScope.launch {
                    requireContext().tokenStore.edit {
                        it[tokenKey] = token
                    }
                }


            })


            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("password", password)

            setFragmentResult("registerRequestKey", bundleOf("email" to email, "password" to password))
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}