package com.example.assignment_007.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.assignment_007.BaseFragment
import com.example.assignment_007.R
import com.example.assignment_007.databinding.FragmentLoginBinding

import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import com.example.assignment_007.extensions.checkEmail
import com.example.assignment_007.home.HomeFragment
import com.example.assignment_007.tokenKey
import com.example.assignment_007.tokenStore
import kotlinx.coroutines.launch


class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginModel>(FragmentLoginBinding::inflate) {

    override fun getViewModel() = LoginModel::class.java

    override var useSharedViewModel = false

    override fun start() {
        loginButtonEnabler()
        setListeners()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("registerRequestKey") { _, bundle ->
            val email = bundle.getString("email")
            val password = bundle.getString("password")

            binding.etPassword.setText(password)
            binding.etEmail.setText(email)

        }

    }

    private fun setListeners() {

        /*  binding.etPassword.doOnTextChanged{text, _,_,_ ->
              if(!binding.etEmail.text.toString().checkEmail()){
                  binding.btnLogin.isEnabled=false
              }

          }*/


        binding.btnLogin.setOnClickListener {



            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val bundle = Bundle()
            bundle.putString("emailLogin", email)


            setFragmentResult(
                "loginEmailRequestKey",
                bundleOf("emailLogin" to email)
            )



            viewModel.goUserLogin(email = email, password = password)
            viewModel.userLogin.observe(viewLifecycleOwner, { response ->
                val token = response.body()?.token ?: "empty token"

                if (binding.checkBox.isChecked){
                    viewLifecycleOwner.lifecycleScope.launch {
                        requireContext().tokenStore.edit { preferences ->
                            preferences[tokenKey] = token
                        }
                    }
                }


                if (!token.isNullOrEmpty()) {
                    Toast.makeText(context, "received token is $token", Toast.LENGTH_SHORT).show()
                    //val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(binding.etEmail.text.toString())
                    //findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                    val ft: FragmentTransaction = activity?.supportFragmentManager!!.beginTransaction()
                    ft.replace(R.id.fragment_container_view, HomeFragment())
                    ft.commit()
                }else{
                    Toast.makeText(context, "unable to Log In, invalid Email or password", Toast.LENGTH_SHORT).show()
                }

            })

            /* val action =
                 LoginFragmentDirections.actionLoginFragmentToHomeFragment(binding.etEmail.text.toString())
             findNavController().navigate(action)*/


        }

        binding.btnRegister.setOnClickListener {


            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun loginButtonEnabler() {
        val email = binding.etEmail
        val password = binding.etPassword


        /* val loginTextWatcher = object : TextWatcher {

             override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

             }

             override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                 if (!email.text.toString().isNullOrEmpty() && !password.text.isNullOrEmpty() && email.text.toString().checkEmail()) {
                     binding.btnLogin.isEnabled = true
                 }
             }

             override fun afterTextChanged(p0: Editable?) {

             }
         }*/
        // email.addTextChangedListener(loginTextWatcher)
        // password.addTextChangedListener(loginTextWatcher)


        email.addTextChangedListener(onTextChanged = { txt, _, _, _ ->
            if (txt.toString().isNotEmpty() && !txt.isNullOrEmpty() && txt.toString()
                    .checkEmail()
            ) {
                binding.btnLogin.isEnabled = true
            }

        })

        password.addTextChangedListener(onTextChanged = { txt, _, _, _ ->
            if (txt.toString().isNotEmpty() && !txt.isNullOrEmpty() && txt.toString()
                    .checkEmail()
            ) {
                binding.btnLogin.isEnabled = true
            }

        })


    }

}