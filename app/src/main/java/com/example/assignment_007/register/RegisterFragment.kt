package com.example.assignment_007.register

import androidx.navigation.fragment.findNavController
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentLoginBinding
import com.example.assignment_007.databinding.FragmentRegisterBinding

class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterModel>(FragmentRegisterBinding::inflate) {

    override fun getViewModel() = RegisterModel::class.java

    override var useSharedViewModel = false

    override fun start() {
        setListeners()
    }


    private fun setListeners(){
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}