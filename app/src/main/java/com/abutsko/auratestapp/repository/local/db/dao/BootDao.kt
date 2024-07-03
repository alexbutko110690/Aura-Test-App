package com.abutsko.auratestapp.repository.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.abutsko.auratestapp.data.db.BootDb

@Dao
interface BootDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: BootDb)
}