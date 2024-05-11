package com.example.listbuku.databasebuku

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class dtbbuku(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id: Int,
    @ColumnInfo(name = "judul")
    val judul: String,
    @ColumnInfo(name = "penulis")
    val penulis: String
)
