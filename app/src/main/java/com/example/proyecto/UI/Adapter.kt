package com.example.proyecto.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.databinding.ItemPuebloBinding
import com.example.proyecto.models.Pueblo

class Adapter(
    private var listPueblo: List<Pueblo>,
    private val deleteOnClick: (Int) -> Unit,
    private val updateOnClick: (Int) -> Unit,
    private val onInfoClickListener: (Pueblo) -> Unit
) : RecyclerView.Adapter<ViewHolderPueblo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPueblo {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemPuebloBinding.inflate(inflater, parent, false)
        return ViewHolderPueblo(itemBinding, deleteOnClick, updateOnClick, onInfoClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolderPueblo, position: Int) {
        holder.bind(listPueblo[position], position)
    }

    override fun getItemCount(): Int = listPueblo.size

    fun updateData(newList: List<Pueblo>) {
        listPueblo = newList
        notifyDataSetChanged()
    }
}