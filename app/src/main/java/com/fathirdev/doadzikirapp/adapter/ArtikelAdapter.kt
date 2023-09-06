package com.fathirdev.doadzikirapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.fathirdev.doadzikirapp.R
import com.fathirdev.doadzikirapp.model.Artikel
import com.fathirdev.doadzikirapp.presentation.DetailArtikelActivity

class ArtikelAdapter(private val listArtikel: ArrayList<Artikel>) :
    RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgArtikel: ImageView = view.findViewById(R.id.img_artikel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_artikel, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listArtikel.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.imgArtikel.setImageResource(data.imageArtikel)
        holder.imgArtikel.setOnClickListener {
            it.context.apply {
                val intent = Intent(this, DetailArtikelActivity::class.java)
                intent.putExtra(DetailArtikelActivity.DATA_TITLE, data.titleArtikel)
                intent.putExtra(DetailArtikelActivity.DATA_DESC, data.descArtikel)
                intent.putExtra(DetailArtikelActivity.DATA_IMAGE, data.imageArtikel)
                startActivity(intent)
            }
        }
    }
}