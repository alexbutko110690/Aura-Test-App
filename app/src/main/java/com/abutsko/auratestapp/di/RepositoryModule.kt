package com.abutsko.auratestapp.di

import com.abutsko.auratestapp.repository.DataRepository
import com.abutsko.auratestapp.repository.DataRepositoryImpl
import com.abutsko.auratestapp.repository.local.LocalRepository
import com.abutsko.auratestapp.repository.local.LocalRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LocalRepository> { LocalRepositoryImpl(get()) }
    single<DataRepository> { DataRepositoryImpl(get()) }
}

