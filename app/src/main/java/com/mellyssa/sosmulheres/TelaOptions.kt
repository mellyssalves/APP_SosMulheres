package com.mellyssa.sosmulheres
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class TelaOptions : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_options)

        val botaoContatos: ImageView  = findViewById(R.id.imageContatos)
        val botaoInformaoces: ImageView = findViewById(R.id.imageView5)

        botaoContatos.setOnClickListener{
            val intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }
        botaoInformaoces.setOnClickListener {
            val bntInformações = Intent(this, telaInformacoes::class.java)
            startActivity(bntInformações)
        }


    }
}