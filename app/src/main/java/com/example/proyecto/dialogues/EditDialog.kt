package com.example.proyecto.dialogues

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R
import com.example.proyecto.models.Pueblo
import kotlin.reflect.KFunction2

class EditDialog(val context: Context) {

    fun showConfirmationDialog(
        pos: Int,
        listaPueblos: MutableList<Pueblo>,
        recyclerView: RecyclerView,
        updatePuebloConfirm: (Int, RecyclerView) -> Unit
    ): AlertDialog? {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.edit_dialog, null)
        val editDialogName = dialogView.findViewById<EditText>(R.id.editDialogName)
        val editDialogHabitants = dialogView.findViewById<EditText>(R.id.editDialogHabitants)
        val editDialogImage = dialogView.findViewById<EditText>(R.id.editDialogImage)
        val pueblo = listaPueblos[pos]

        editDialogName.setText(pueblo.name)
        editDialogHabitants.setText(pueblo.habitants)
        editDialogImage.setText(pueblo.image)

        return AlertDialog.Builder(context)
            .setView(dialogView)
            .setPositiveButton("Editar") { dialog, _ ->
                val name = editDialogName.text.toString()
                val habitants = editDialogHabitants.text.toString()
                val url = editDialogImage.text.toString()
                if (name.isNotEmpty() && habitants.isNotEmpty() && url.isNotEmpty()) {
                    val nuevoPueblo = Pueblo(name, habitants, url)
                    listaPueblos[pos] = nuevoPueblo
                    updatePuebloConfirm(pos, recyclerView)
                    Toast.makeText(context, "Pueblo editado correctamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Debes completar todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }
}