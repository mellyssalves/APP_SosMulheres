package com.mellyssa.sosmulheres

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.core.View
import com.mellyssa.sosmulheres.model.ContatoModel

class MyAdapter(private val contatoList: ArrayList<ContatoModel>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contato_item,
            parent,false)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  contatoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentitem = contatoList[position]

        holder.Nome.text = currentitem.nome
        holder.Numero.text = currentitem.telefone
    }

    class MyViewHolder(itemView: android.view.View): RecyclerView.ViewHolder(itemView){

        val Nome: TextView = itemView.findViewById(R.id.tvNome)
        val Numero: TextView = itemView.findViewById(R.id.tvNumero)

    }
}