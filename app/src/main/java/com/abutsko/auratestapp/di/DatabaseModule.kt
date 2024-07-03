package com.abutsko.auratestapp.di

import androidx.room.Room
import com.abutsko.auratestapp.repository.local.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "aura_test_app_db"

val databaseModule = module {
    single(createdAtStart = true) {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, DATABASE_NAME)
            .build()
    }
    single { get<AppDatabase>().bootDao() }

}