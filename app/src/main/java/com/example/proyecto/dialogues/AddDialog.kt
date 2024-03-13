package com.example.proyecto.dialogues

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R
import com.example.proyecto.models.Pueblo
import kotlin.reflect.KFunction2

class AddDialog(private val context: Context) {

    fun onCreateDialog(
        listaPueblos: MutableList<Pueblo>,
        recyclerView: RecyclerView,
        confirmPueblo: (Int, RecyclerView) -> Unit
    ): AlertDialog {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.add_dialog, null)

        return AlertDialog.Builder(context)
            .setView(dialogView)
            .setPositiveButton("Guardar") { dialog, _ ->
                val addDialogName = dialogView.findViewById<EditText>(R.id.addDialogName)
                val addDialogHabitants = dialogView.findViewById<EditText>(R.id.addDialogHabitants)
                val addDialogImage = dialogView.findViewById<EditText>(R.id.addDialogImage)

                val name = addDialogName.text.toString()
                val habitants = addDialogHabitants.text.toString()
                val url = addDialogName.text.toString()

                if (name.isNotEmpty() && habitants.isNotEmpty() && url.isNotEmpty()) {
                    val pueblo = Pueblo(name, habitants, url)
                    listaPueblos.add(pueblo)
                    val newPos = listaPueblos.indexOf(pueblo)
                    confirmPueblo(newPos, recyclerView)
                    Toast.makeText(context, "Pueblo añadido correctamente", Toast.LENGTH_SHORT).show()
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