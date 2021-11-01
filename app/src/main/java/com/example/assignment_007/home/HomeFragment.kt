package com.example.assignment_007.home

import android.os.Bundle
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.asLiveData
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentHomeBinding
import com.example.assignment_007.databinding.FragmentLoginBinding
import com.example.assignment_007.databinding.FragmentRegisterBinding
import com.example.assignment_007.tokenKey
import com.example.assignment_007.tokenStore
import kotlinx.coroutines.flow.map

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeModel>(FragmentHomeBinding::inflate) {

    private val args: HomeFragmentArgs by navArgs()

    override fun getViewModel() = HomeModel::class.java

    override var useSharedViewModel = false

    override fun start() {

        binding.tvEmail.text = args.emailArgument
        showToken()
        setListeners()


    }


    private fun setListeners() {
        binding.btnLogOut.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

    private fun showToken(){
        requireContext().tokenStore.data.map {
            it[tokenKey] ?:"empty key"
        }.asLiveData().observe(viewLifecycleOwner,{
            binding.tvInfo.text = it
        })
    }

}