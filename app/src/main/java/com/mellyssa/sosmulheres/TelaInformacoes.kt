package com.mellyssa.sosmulheres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mellyssa.sosmulheres.databinding.ActivityTelaInformacoesBinding

class TelaInformacoes : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInformacoesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInformacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}