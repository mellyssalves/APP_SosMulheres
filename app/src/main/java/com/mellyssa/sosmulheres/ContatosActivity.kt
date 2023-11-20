package com.mellyssa.sosmulheres

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

import com.mellyssa.sosmulheres.databinding.ActivityContatosBinding
import com.mellyssa.sosmulheres.model.ContatoModel
import com.mellyssa.sosmulheres.model.UsuarioModel

class ContatosActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var binding: ActivityContatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        binding.buttonSalvar.setOnClickListener {
            val nome = binding.editNomeContato.text.toString()
            val telefone = binding.editTextPhoneContatos.text.toString()


            if(nome.isNotEmpty()&& telefone.isNotEmpty()){
                cadastrarContato(nome,telefone)
            }else{
                Toast.makeText(this, "Preencha os campos acima.",Toast.LENGTH_SHORT,).show()
            }
        }




    }
    private fun cadastrarContato(nome:String,telefone:String){

            val contact = ContatoModel(
                 nome, telefone
            )
        db.collection("contatos").document(contact.nome).set(contact).addOnSuccessListener{
            Toast.makeText(applicationContext, "Contato salvo com sucesso!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,ListaContatosActivity::class.java))
        }.addOnFailureListener{
            Toast.makeText(applicationContext, "Erro ao realizar cadastro", Toast.LENGTH_LONG).show()
        }
    }
}