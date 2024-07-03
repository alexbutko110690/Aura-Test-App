package com.abutsko.auratestapp.usecase

import com.abutsko.auratestapp.usecase.getBootList.GetBootListUseCase
import com.abutsko.auratestapp.usecase.getBootList.GetBootListUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetBootListUseCase> { GetBootListUseCaseImpl(get()) }
}