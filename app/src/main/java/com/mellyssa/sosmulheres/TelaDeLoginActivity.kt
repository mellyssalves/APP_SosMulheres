package com.mellyssa.sosmulheres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase

import com.mellyssa.sosmulheres.databinding.TelaDeLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.mellyssa.sosmulheres.databinding.ActivityCadastroBinding

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

            if(email.isNotEmpty() && senha.isNotEmpty()){
                login(email,senha)
                }else{
                    Toast.makeText(this@TelaDeLoginActivity, "Prencha os campos corretamente",Toast.LENGTH_SHORT,).show()
                }



        }

    }


    private fun login(email: String, senha: String) {
        auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener{
            if(it.isSuccessful){
                val intent = Intent(this, TelaOptions::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(baseContext,"email ou senha inválidos",Toast.LENGTH_SHORT,).show()
            }
        }

    }
    companion object{
    private var TAG= "emailEsenha"
}






}