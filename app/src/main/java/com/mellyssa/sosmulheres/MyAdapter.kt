package com.mellyssa.sosmulheres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mellyssa.sosmulheres.model.Contato

class MyAdapter(private val contactList: ArrayList<Contato>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,
            parent, false )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       // val currentitem = contactList[position]

        holder.nome.text = contactList[position].nome
        holder.telefone.text =  contactList[position].telefone

    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nome : TextView = itemView.findViewById(R.id.tvNomeList)
        val telefone: TextView = itemView.findViewById(R.id.tvTelefoneList)
    }

}