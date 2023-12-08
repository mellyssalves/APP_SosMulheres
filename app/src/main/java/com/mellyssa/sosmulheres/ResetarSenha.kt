package com.mellyssa.sosmulheres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mellyssa.sosmulheres.databinding.ActivityResetarSenhaBinding

class ResetarSenha : AppCompatActivity() {

    private lateinit var binding: ActivityResetarSenhaBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetarSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnResetar.setOnClickListener {
            val sPassword = binding.etResetar.text.toString()
            auth.sendPasswordResetEmail(sPassword).addOnSuccessListener {
                Toast.makeText(this, "Verifique seu email", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }


    }
}