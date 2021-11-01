package com.example.assignment_007.home

import android.os.Bundle
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentHomeBinding
import com.example.assignment_007.databinding.FragmentLoginBinding
import com.example.assignment_007.databinding.FragmentRegisterBinding
import com.example.assignment_007.login.LoginFragment
import com.example.assignment_007.tokenKey
import com.example.assignment_007.tokenStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeModel>(FragmentHomeBinding::inflate) {

    //private val args: HomeFragmentArgs by navArgs()

    override fun getViewModel() = HomeModel::class.java

    override var useSharedViewModel = false

    override fun start() {



        //  binding.tvEmail.text = args.emailArgument
        // showToken()
        setListeners()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("loginEmailRequestKey") { _, bundle ->
            val email = bundle.getString("emailLogin")

            binding.tvEmail.text = email

        }
    }


    private fun setListeners() {
        binding.btnLogOut.setOnClickListener {

            viewLifecycleOwner.lifecycleScope.launch {
                requireContext().tokenStore.edit {
                    it.remove(tokenKey)
                }
            }


            val ft: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
            ft.replace(R.id.fragment_container_view, LoginFragment())
            ft.commit()

            // findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

    /*   private fun showToken(){
           requireContext().tokenStore.data.map {
               it[tokenKey] ?:"empty key from home fragment"
           }.asLiveData().observe(viewLifecycleOwner,{
               binding.tvInfo.text = it
           })
       }*/

}