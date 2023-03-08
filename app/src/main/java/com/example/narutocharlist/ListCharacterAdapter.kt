package com.example.myrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.narutocharlist.Character
import com.example.narutocharlist.DetailCharacter
import com.example.narutocharlist.R

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>) :
    RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_character, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCharacter[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailCharacter::class.java)
            intent.putExtra(DetailCharacter.CHARACTER_NAME, listCharacter[holder.adapterPosition].name)
            intent.putExtra(DetailCharacter.CHARACTER_DESCRIPTION, listCharacter[holder.adapterPosition].description)
            intent.putExtra(DetailCharacter.CHARACTER_PHOTO, listCharacter[holder.adapterPosition].photo)
            intent.putExtra(DetailCharacter.CHARACTER_BACKGROUND, listCharacter[holder.adapterPosition].background)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listCharacter.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}