package buu.informatics.s59160965.qrcodescanner.screens.login


import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import buu.informatics.s59160965.qrcodescanner.R
import buu.informatics.s59160965.qrcodescanner.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login,container,false)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventClick.observe(this, Observer<Boolean> { data ->
            if(data){
                if(binding.nameInput.text.toString() != ""){
//                    this.findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
                    var inputname = binding.nameInput.text.toString()
//                    view!!.findNavController().navigate(
//                        LoginFragmentDirections.actionLoginFragmentToMenuFragment(inputname))

                    this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMenuFragment(inputname))


                    activity?.hideSoftKeyboard()
                }else{
                    Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
                }

            }
        })

        return binding.root
    }

    fun Activity.hideSoftKeyboard() {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(Context
                .INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

}
