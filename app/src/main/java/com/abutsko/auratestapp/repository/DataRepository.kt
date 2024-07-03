package com.abutsko.auratestapp.repository

import com.abutsko.auratestapp.data.local.BootCountLocal

interface DataRepository {

    suspend fun getBootList(): List<BootCountLocal>
}