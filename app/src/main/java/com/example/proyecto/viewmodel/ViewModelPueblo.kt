package com.example.proyecto.viewmodel

import android.widget.ImageButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.UI.Adapter
import com.example.proyecto.dialogues.AddDialog
import com.example.proyecto.dialogues.DeleteDialog
import com.example.proyecto.dialogues.EditDialog
import com.example.proyecto.models.Pueblo
import com.example.proyecto.objets_models.Repository
import com.example.proyecto.ListFragmentDirections

class ViewModelPueblo : ViewModel() {
    private val listaPueblos: MutableLiveData<List<Pueblo>> = MutableLiveData()

    init {
        initData()
    }

    private fun initData() {
        listaPueblos.value = Repository.listaPueblos.toMutableList()
    }

    fun getListPueblos(): LiveData<List<Pueblo>> {
        return listaPueblos
    }

    private fun updatePuebloConfirm(pos: Int, recyclerView: RecyclerView) {
        recyclerView.adapter?.notifyItemChanged(pos)
    }

    fun confirmPueblo(pos: Int, recyclerView: RecyclerView) {
        recyclerView.adapter?.notifyItemInserted(pos)
        recyclerView.smoothScrollToPosition(pos)
    }
    fun setAdapter(recyclerView: RecyclerView) {
        recyclerView.adapter = Adapter(
            listaPueblos.value as MutableList<Pueblo>,
            { pos -> delPueblo(pos, recyclerView) },
            { pos -> updatePueblo(pos, recyclerView) },
            { pueblo -> infoPueblo(pueblo, recyclerView)}
        )
    }

    fun setAddButton(addButton: ImageButton, recyclerView: RecyclerView) {
        addButton.setOnClickListener {
            addPueblo(recyclerView)
        }
    }
    fun delPueblo(pos: Int, recyclerView: RecyclerView) {
        val alertDialogHelper = DeleteDialog(recyclerView.context)
        alertDialogHelper.showConfirmationDialog(pos, listaPueblos.value as MutableList<Pueblo>, listaPueblos.value!![pos].name, recyclerView)
    }

    fun updatePueblo(pos: Int, recyclerView: RecyclerView) {
        val dialog = EditDialog(recyclerView.context)
        val alertDialog = dialog.showConfirmationDialog(pos, listaPueblos.value as MutableList<Pueblo>, recyclerView, ::updatePuebloConfirm)
        alertDialog?.show()
    }

    fun addPueblo(recyclerView: RecyclerView) {
        val dialog = AddDialog(recyclerView.context)
        val alertdialog = dialog.onCreateDialog(listaPueblos.value as MutableList<Pueblo>, recyclerView, ::confirmPueblo)
        alertdialog.show()
    }

    fun infoPueblo(pueblo: Pueblo, recyclerView: RecyclerView) {
        val navController = recyclerView.findNavController()
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(image = pueblo.image, name = pueblo.name,  habitants = pueblo.habitants)
        navController.navigate(action)
    }

}