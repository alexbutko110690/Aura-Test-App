package com.abutsko.auratestapp.usecase.getBootList

import com.abutsko.auratestapp.data.local.BootCountLocal

interface GetBootListUseCase {

    suspend fun getBootList(): List<BootCountLocal>
}