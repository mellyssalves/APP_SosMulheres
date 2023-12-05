package com.mellyssa.sosmulheres

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.mellyssa.sosmulheres.databinding.ActivityListaContatosBinding
import com.mellyssa.sosmulheres.model.Contato

class ListaContatosActivity : AppCompatActivity() {

    private  var db = Firebase.firestore
    private lateinit var contactRecyclerView: RecyclerView
    private lateinit var contactArrayList: ArrayList<Contato>
    private lateinit var binding: ActivityListaContatosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityListaContatosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contatos)

        setContentView(binding.root)


        contactRecyclerView = findViewById(R.id.lista_contatos) // id do RecyclerView
        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        contactRecyclerView.setHasFixedSize(true)

        contactArrayList = arrayListOf<Contato>()
        db = FirebaseFirestore.getInstance()
        db.collection("contatos").get().addOnSuccessListener {
            if(!it.isEmpty){
                for (data in it.documents){
                    val contact: Contato? = data.toObject(Contato::class.java)
                    if (contact != null) {
                        contactArrayList.add(contact)
                    }
                }
                contactRecyclerView.adapter = MyAdapter(contactArrayList)
            }
        }.addOnFailureListener{
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }


      binding.buttonAdd.setOnClickListener {
            val addContato = Intent(this, ContatosActivity::class.java)
            startActivity(addContato)


        }
    }










            

    }


