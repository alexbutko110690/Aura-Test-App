package com.abutsko.auratestapp.screen

import com.abutsko.auratestapp.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainViewModel(get()) }
}