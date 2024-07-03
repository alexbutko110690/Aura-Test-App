package com.abutsko.auratestapp.repository.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abutsko.auratestapp.data.db.BootDb

@Dao
interface BootDao {

    @Query("SELECT * FROM boot")
    fun getAllBoots(): List<BootDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: BootDb)
}