package com.example.listbuku

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class bukadetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menampilkan)
        val bundle: Bundle? = intent.extras
        val judul: TextView =findViewById(R.id.tjudul)
        val penulis: TextView =findViewById(R.id.tpenulis)
        judul.text=bundle?.getString("judul")
        penulis.text=bundle?.getString("penulis")
    }
}