package com.abutsko.auratestapp.repository.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abutsko.auratestapp.data.db.BootDb
import com.abutsko.auratestapp.repository.local.db.converter.DateConverter
import com.abutsko.auratestapp.repository.local.db.dao.BootDao

@Database(
    entities = [
        BootDb::class,
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    DateConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bootDao(): BootDao
}