package com.example.assignment_007.home

import androidx.navigation.fragment.findNavController
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentHomeBinding
import com.example.assignment_007.databinding.FragmentLoginBinding
import com.example.assignment_007.databinding.FragmentRegisterBinding

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeModel>(FragmentHomeBinding::inflate) {

    override fun getViewModel() = HomeModel::class.java

    override var useSharedViewModel=false

    override fun start() {

        setListeners()

    }

    private fun setListeners(){
        binding.btnLogOut.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

}