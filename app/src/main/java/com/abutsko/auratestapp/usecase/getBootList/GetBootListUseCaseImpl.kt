package com.abutsko.auratestapp.usecase.getBootList

import com.abutsko.auratestapp.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetBootListUseCaseImpl(
    private val dataRepository: DataRepository
): GetBootListUseCase {
    override suspend fun getBootList() = withContext(Dispatchers.IO) {
        dataRepository.getBootList()
    }
}