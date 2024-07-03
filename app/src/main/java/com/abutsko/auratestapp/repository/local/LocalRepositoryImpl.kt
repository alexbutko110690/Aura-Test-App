package com.abutsko.auratestapp.repository.local

import com.abutsko.auratestapp.data.db.BootDb
import com.abutsko.auratestapp.repository.local.db.dao.BootDao

class LocalRepositoryImpl(
    private val bootDao: BootDao
): LocalRepository {
    override suspend fun getAllBoots(): List<BootDb> {
        return bootDao.getAllBoots()
    }
}