package com.example.listbuku.databasebuku

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.listbuku.buku

@Dao
interface CRUD {
    @Insert
    fun addbuku(buku: dtbbuku)

    @Update
    fun updatebuku(buku: dtbbuku)

    @Delete
    fun deletebuku(buku: dtbbuku)

    @Query("SELECT * FROM dtbbuku")
    fun getbuku(): List<dtbbuku>
}