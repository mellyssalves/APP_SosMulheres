package com.mellyssa.sosmulheres

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import com.mellyssa.sosmulheres.databinding.ActivityListaContatosBinding
import com.mellyssa.sosmulheres.model.ContatoModel

class ListaContatosActivity : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var contactReciclerView : RecyclerView
    private lateinit var contatoList: ArrayList<ContatoModel>
    private lateinit var binding: ActivityListaContatosBinding

    private lateinit var adapter: ArrayAdapter<ContatoModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaContatosBinding.inflate(layoutInflater)
        setContentView(binding.root)    

        contactReciclerView = findViewById(R.id.lista_contatos)
        contactReciclerView.layoutManager = LinearLayoutManager(this)
        contactReciclerView.setHasFixedSize(true)

        contatoList = arrayListOf<ContatoModel>()
        getContactData()

        binding.buttonAdd.setOnClickListener {
            startActivity(Intent(applicationContext, ContatosActivity::class.java))
        }
        }

    private fun getContactData() {
        dbref = FirebaseDatabase.getInstance().getReference("contatos")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for(contactSnapshot in snapshot.children){

                        val contact = contactSnapshot.getValue(ContatoModel::class.java)
                        contatoList.add(contact!!)
                    }
                    contactReciclerView.adapter = MyAdapter(contatoList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}




