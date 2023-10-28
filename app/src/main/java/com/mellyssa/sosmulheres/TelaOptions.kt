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

        val botaoDenunciar: ImageView  = findViewById(R.id.imageDenunciar)

        botaoDenunciar.setOnClickListener{
            val intent = Intent(this, TelaDeLoginActivity::class.java)
            startActivity(intent)
        }

    }
}