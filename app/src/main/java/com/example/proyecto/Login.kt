package com.example.proyecto


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    val userViewModel : UserViewModel by viewModels()  //viewModel del Usuario.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerLiveData()
        initEvent()
    }

    private fun initEvent() {
        binding.btnValidar.setOnClickListener{
            userViewModel.isLogin(binding.etUser.text.toString(), binding.etContra.text.toString())

        }
        binding.btnRegistrar.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    private fun registerLiveData() {
        userViewModel.login.observe(this,
            {
                    login->
                if (login) {
                    //aquí tengo que lanzar el activity ppal.
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Error en el logueo", Toast.LENGTH_LONG).show()
                }
            }
        )
    }
}
