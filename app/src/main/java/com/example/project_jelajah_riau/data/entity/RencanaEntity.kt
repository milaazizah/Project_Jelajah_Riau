package com.example.project_jelajah_riau.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rencana")
data class RencanaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val daerah: String,
    val tanggal: String,
    val catatan: String,
    val createdAt: Long = System.currentTimeMillis()
)