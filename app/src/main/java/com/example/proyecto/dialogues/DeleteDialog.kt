package com.example.proyecto.dialogues

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.models.Pueblo

class DeleteDialog(val context: Context) {

    fun showConfirmationDialog(pos: Int, listaPueblos: MutableList<Pueblo>, name: String, recyclerView: RecyclerView) {
        val alertDialogBuilder = AlertDialog.Builder(context).apply {
            setTitle("Confirmar eliminación")
            setMessage("¿Seguro que quieres eliminar el pueblo $name?")
            setPositiveButton("Si") { dialog, _ ->
                removePueblo(pos, listaPueblos, recyclerView)
                dialog.dismiss()
            }
            setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        }
        alertDialogBuilder.create().show()
    }

    private fun removePueblo(pos: Int, listaPueblos: MutableList<Pueblo>, recyclerView: RecyclerView) {
        listaPueblos.removeAt(pos)
        recyclerView.adapter?.notifyItemRemoved(pos)
        recyclerView.adapter?.notifyItemRangeChanged(pos, listaPueblos.size)
        Toast.makeText(context, "Se eliminó el pueblo ", Toast.LENGTH_LONG).show()
    }
}