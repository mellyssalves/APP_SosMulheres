package com.mellyssa.sosmulheres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.mellyssa.sosmulheres.databinding.ActivityTelaOperacoesContatoBinding
import com.mellyssa.sosmulheres.model.ContatoModel

class TelaOperacoesContato : AppCompatActivity() {

    private lateinit var binding: ActivityTelaOperacoesContatoBinding


    private var contatoModel =  ContatoModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaOperacoesContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //variavel para pegar os valores que vão ser inseridos



        binding.btnCancelar.setOnClickListener {
            //volta aos parametros iniciais
            binding.editNomeContato.setText(contatoModel.nome)
            binding.editNomeContato.setText(contatoModel.telefone.toString())
        }

        binding.btnSalvar.setOnClickListener {

        }



    }
}