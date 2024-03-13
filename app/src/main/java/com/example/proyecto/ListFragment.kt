package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.UI.Adapter
import com.example.proyecto.databinding.FragmentListBinding
import com.example.proyecto.viewmodel.ViewModelPueblo

class ListFragment : Fragment() {
    private val viewModelPueblo: ViewModelPueblo by viewModels()
    private lateinit var binding: FragmentListBinding
    private lateinit var floatingButton: ImageButton
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        val rootView = binding.root
        floatingButton = binding.btnAdd
        recyclerView = binding.myRecyclerView

        init()
        return rootView
    }

    private fun init() {
        initRecyclerView()

        viewModelPueblo.getListPueblos().observe(viewLifecycleOwner) { pueblos ->
            (recyclerView.adapter as? Adapter)?.updateData(pueblos)
        }

        viewModelPueblo.setAdapter(recyclerView)
        viewModelPueblo.setAddButton(floatingButton, recyclerView)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}