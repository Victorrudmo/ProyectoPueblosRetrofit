package com.example.proyecto.UI

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.databinding.ItemPuebloBinding
import com.example.proyecto.models.Pueblo

class ViewHolderPueblo(
    private val binding: ItemPuebloBinding,
    private val deleteOnClick: (Int) -> Unit,
    private val updateOnClick: (Int) -> Unit,
    private val onInfoClickListener: (Pueblo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pueblo: Pueblo, position: Int) {
        binding.apply {
            txtviewName.text = pueblo.name
            txtviewHabitants.text = pueblo.habitants
            Glide.with(itemView.context)
                .load(pueblo.image)
                .centerCrop()
                .into(ivPueblo)
            setOnClickListeners(position, pueblo)
        }
    }

    private fun setOnClickListeners(position: Int, pueblo: Pueblo) {
        binding.btnEdit.setOnClickListener {
            updateOnClick(position)
        }
        binding.btnDelete.setOnClickListener {
            deleteOnClick(position)
        }
        binding.btnInfo.setOnClickListener {
            onInfoClickListener(pueblo)
        }
    }
}