package com.mellyssa.sosmulheres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mellyssa.sosmulheres.databinding.TelaDeLoginBinding
class TelaDeLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_de_login)

        binding = TelaDeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoLogin.setOnClickListener{
            val botaoLogin = Intent(this, TelaOptions::class.java)
            startActivity( botaoLogin)
        }
        }
    private lateinit var binding: TelaDeLoginBinding
    }
