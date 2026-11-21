package com.example.project_jelajah_riau.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.project_jelajah_riau.data.entity.RencanaEntity

@Dao
interface RencanaDao {
    @Query("SELECT * FROM rencana ORDER BY createdAt DESC")
    suspend fun getAll(): List<RencanaEntity>

    @Insert
    suspend fun insert(rencana: RencanaEntity)

    @Delete
    suspend fun delete(rencana: RencanaEntity)
}