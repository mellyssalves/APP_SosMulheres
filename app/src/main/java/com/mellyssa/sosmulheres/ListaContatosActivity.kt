package com.mellyssa.sosmulheres

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mellyssa.sosmulheres.databinding.ActivityListaContatosBinding

class ListaContatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListaContatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNovoContato.setOnClickListener {
            val addContato = Intent(this, ContatosActivity::class.java)
            startActivity(addContato)


        }
    }

   private lateinit var binding: ActivityListaContatosBinding
}