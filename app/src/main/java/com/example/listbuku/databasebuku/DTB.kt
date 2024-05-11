package com.example.listbuku.databasebuku

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [dtbbuku::class],
    version = 1
)
abstract class DTB : RoomDatabase(){

    abstract fun Dao() : CRUD

    companion object {

        @Volatile private var instance : DTB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DTB::class.java,
            "daftar.buku"
        ).build()

        }
}