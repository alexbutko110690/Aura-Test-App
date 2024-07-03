package com.abutsko.auratestapp.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "boot")
open class BootDb(
    @ColumnInfo(name = "date")
    val date: Date,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0
)