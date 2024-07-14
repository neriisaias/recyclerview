package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class CustomAdapter(var lista: List<String>) : RecyclerView.Adapter<CustomHolder>() {

    private val cores = arrayOf(
        R.color.C1,
        R.color.C2,
        R.color.C3,
        R.color.C4,
        R.color.C5,
        R.color.C6,
        R.color.C7,
        R.color.C8,
        R.color.C9,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomHolder(layoutView)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.configurar(lista[position])

        val context = holder.itemView.context
        val colorRes = context.resources.getColor(cores[position % cores.size], context.theme)
        holder.itemView.setBackgroundColor(colorRes)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    // Método para atualizar a lista de dados
    fun atualizarLista(novaLista: List<String>) {
        lista = novaLista
        notifyDataSetChanged()  }
}