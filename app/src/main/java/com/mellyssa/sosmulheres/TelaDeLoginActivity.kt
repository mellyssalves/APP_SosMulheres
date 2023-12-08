package com.mellyssa.sosmulheres

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mellyssa.sosmulheres.databinding.TelaDeLoginBinding
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.auth
import com.google.rpc.context.AttributeContext.Auth
import com.mellyssa.sosmulheres.databinding.ActivityCadastroBinding
import com.mellyssa.sosmulheres.databinding.ActivityResetarSenhaBinding


class TelaDeLoginActivity : AppCompatActivity() {
    private lateinit var binding: TelaDeLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = TelaDeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.botaoLogin.setOnClickListener {
            val email: String = binding.editTextTextEmailAddress2.text.toString()
            val senha: String = binding.editTextTextPassword2.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                login(email, senha)
            } else {
                Toast.makeText(
                    this@TelaDeLoginActivity,
                    "Prencha os campos corretamente",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }

        binding.textForgot.setOnClickListener {
            val intent = Intent(this, ResetarSenha::class.java)
            startActivity(intent)
        }


    }




    private fun login(email: String, senha: String) {
        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {
                val intent = Intent(this, TelaOptions::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(baseContext, "email ou senha inválidos", Toast.LENGTH_SHORT,).show()
            }
        }
    }


    companion object{
        private var TAG= "emailEsenha"
    }



}
