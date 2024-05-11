package com.example.listbuku

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listbuku.databasebuku.DTB
import com.example.listbuku.databasebuku.dtbbuku
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class adapter(private val context: Context, private val data: MutableList<dtbbuku>) :
    RecyclerView.Adapter<adapter.bukuViewHolder>() {
    val dbbook by lazy { DTB(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bukuViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.itembuku, parent, false)
        return bukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: bukuViewHolder, position: Int) {
        val detailbuku = data[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(context, bukadetail::class.java)
            intent.putExtra("judul", detailbuku.judul)
            intent.putExtra("penulis", detailbuku.penulis)
            context.startActivity(intent)
        }
        holder.tvjudul.text = detailbuku.judul
        holder.tvpenulis.text = detailbuku.penulis

        holder.hapus.setOnClickListener(){
            val itemPosition = holder.adapterPosition
            if (itemPosition != RecyclerView.NO_POSITION) {
                CoroutineScope(Dispatchers.IO).launch {
                    val deletebook = data[itemPosition]
                    dbbook.Dao().deletebuku(deletebook)
                    withContext(Dispatchers.Main){
                        data.removeAt(itemPosition)
                        notifyItemRemoved(itemPosition)
                    }
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(list: List<dtbbuku>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class bukuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvjudul: TextView = itemView.findViewById(R.id.judul)
        val tvpenulis: TextView = itemView.findViewById(R.id.Penulis)
        val hapus : ImageButton = itemView.findViewById(R.id.delete)
    }


}
