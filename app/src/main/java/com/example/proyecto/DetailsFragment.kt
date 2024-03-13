package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {

    private lateinit var imageViewPueblo: ImageView
    private lateinit var textViewName: TextView
    private lateinit var textViewHabitants: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)

        imageViewPueblo = rootView.findViewById(R.id.imapueblo)
        textViewName = rootView.findViewById(R.id.textpueblo1)
        textViewHabitants = rootView.findViewById(R.id.textpueblo2)

        val image = arguments?.getString("image")
        val name = arguments?.getString("name")
        val habitants = arguments?.getString("habitants")

        image?.let {
            Glide.with(this)
                .load(it)
                .centerCrop()
                .into(imageViewPueblo)
        }

        textViewName.text = name ?: ""
        textViewHabitants.text = habitants ?: ""

        return rootView
    }
}