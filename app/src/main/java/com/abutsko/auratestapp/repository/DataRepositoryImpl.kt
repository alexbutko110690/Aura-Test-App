package com.abutsko.auratestapp.repository

import com.abutsko.auratestapp.data.db.BootDb
import com.abutsko.auratestapp.data.local.BootCountLocal
import com.abutsko.auratestapp.repository.local.LocalRepository
import com.abutsko.auratestapp.utils.equalsWithoutTime

class DataRepositoryImpl(private val localRepository: LocalRepository) : DataRepository {

    override suspend fun getBootList(): List<BootCountLocal> {
        val allBoots = localRepository.getAllBoots()
        val bootList = mutableListOf<BootCountLocal>()
        var prev: BootDb? = null
        allBoots.forEach {
            if (prev != null && prev?.date?.equalsWithoutTime(it.date) == true) {
                val last = bootList.last()
                bootList.removeLast()
                bootList.add(BootCountLocal(last.date, (last.times) + 1))
            } else {
                bootList.add(BootCountLocal(it.date, 1))
            }
            prev = it
        }
        return bootList
    }
}