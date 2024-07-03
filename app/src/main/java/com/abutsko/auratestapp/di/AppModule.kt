package com.abutsko.auratestapp.di

import com.abutsko.auratestapp.screen.mainModule
import com.abutsko.auratestapp.usecase.useCaseModule

val appModule = listOf(
    databaseModule,
    repositoryModule,
    useCaseModule,
    mainModule,
)
