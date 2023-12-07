package com.mellyssa.sosmulheres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.mellyssa.sosmulheres.databinding.ActivityListaContatosBinding
import com.mellyssa.sosmulheres.databinding.ActivityTelaOperacoesContatoBinding

class TelaOperacoesContato : AppCompatActivity() {

    private lateinit var binding: ActivityTelaOperacoesContatoBinding

    private  var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityTelaOperacoesContatoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonDeletar.setOnClickListener {
            if(binding.nome.text.isNotEmpty()){
                val query = db.collection("contatos").whereEqualTo("nome", binding.nome.text.toString())
                    .get()
                query.addOnSuccessListener {
                    for (document in it){
                        db.collection("contatos").document(document.id).delete().addOnSuccessListener {
                            Toast.makeText(applicationContext, "Contato excluido", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }
}