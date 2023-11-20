package com.mellyssa.sosmulheres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mellyssa.sosmulheres.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val cadastrar = Intent(this,CadastroActivity::class.java)
            startActivity(cadastrar)
        }

        binding.botaoEntrar.setOnClickListener {
            val intent =  Intent(this, TelaDeLoginActivity::class.java)
            startActivity(intent)
        }


        }

    }


