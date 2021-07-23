package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class Recycler_adapter : RecyclerView.Adapter<Recycler_adapter.ViewHolder>(){

    private var title= arrayOf("item one","item two","item three","item four","item five","item six","item seven","item eight","item nine","item ten")
    private var images= intArrayOf(R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1,R.drawable.ppl1)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recycler_adapter.ViewHolder {
       val v= LayoutInflater.from(parent.context).inflate(R.layout.cardlayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Recycler_adapter.ViewHolder, position: Int) {
      holder.itemTitle.text=title[position]
     holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage=itemView.findViewById(R.id.item_image)
            itemTitle=itemView.findViewById(R.id.itee_title)

            itemView.setOnClickListener{
                val position: Int= adapterPosition

                Toast.makeText(itemView.context,"clicked",Toast.LENGTH_SHORT).show()
            }

        }
    }
}