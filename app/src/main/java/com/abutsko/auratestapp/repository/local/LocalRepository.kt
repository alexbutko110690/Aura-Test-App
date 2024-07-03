package com.abutsko.auratestapp.repository.local

import com.abutsko.auratestapp.data.db.BootDb

interface LocalRepository {

    suspend fun getAllBoots(): List<BootDb>
}