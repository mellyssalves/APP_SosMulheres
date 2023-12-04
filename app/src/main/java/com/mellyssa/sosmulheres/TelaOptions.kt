package com.mellyssa.sosmulheres
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mellyssa.sosmulheres.databinding.ActivityMainBinding
import com.mellyssa.sosmulheres.databinding.ActivityTelaOptionsBinding
import com.mellyssa.sosmulheres.databinding.TelaDeLoginBinding


class TelaOptions : AppCompatActivity() {
    private val binding by lazy{
        ActivityTelaOptionsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val botaoContatos: ImageView  = findViewById(R.id.imageView6)
        val botaoInformaoces: ImageView = findViewById(R.id.imageView5)

        botaoContatos.setOnClickListener {
            val intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }

        botaoInformaoces.setOnClickListener {
            val bntInformações = Intent(this, TelaInformacoes::class.java)
            startActivity(bntInformações)
        }
        inicializaToolbar()
        }
    private fun inicializaToolbar(){
        val toolbar = binding.toolbarOptions.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply{
            title = "TESTE"
            setDisplayHomeAsUpEnabled(true)
        }
    }



}