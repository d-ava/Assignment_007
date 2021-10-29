package com.example.assignment_007.login

import androidx.navigation.fragment.findNavController
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentLoginBinding

class LoginFragment: BaseFragment<FragmentLoginBinding, LoginModel>(FragmentLoginBinding::inflate) {

    override fun getViewModel() = LoginModel::class.java

    override var useSharedViewModel=false

    override fun start() {

        setListeners()

    }


    private fun setListeners(){
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }


        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }


}