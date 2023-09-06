package com.fathirdev.doadzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fathirdev.doadzikirapp.R
import com.fathirdev.doadzikirapp.model.DzikirDoa

class DoaDzikirAdapter(private val listDzikirDoa: ArrayList<DzikirDoa>) : RecyclerView.Adapter<DoaDzikirAdapter.DzikirViewHolder>() {

    // viewholder take responsibility for intialize item view from layout
    // in this class we will describes our item view from layout
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemArabic: TextView = view.findViewById(R.id.item_arabic)
        val itemTranslate: TextView = view.findViewById(R.id.item_translate)
    }

    // oncreateviewholder provides layout to be used viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.item_doa_dzikir, parent, false)
        )


    override fun getItemCount() = listDzikirDoa.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        val data = listDzikirDoa[position]
        holder.apply {
            itemTitle.text = data.title
            itemArabic.text = data.arabic
            itemTranslate.text = data.translate
        }
    }
}