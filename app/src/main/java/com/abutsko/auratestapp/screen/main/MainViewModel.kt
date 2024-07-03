package com.abutsko.auratestapp.screen.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abutsko.auratestapp.data.local.BootCountLocal
import com.abutsko.auratestapp.screen.base.BaseViewModel
import com.abutsko.auratestapp.usecase.getBootList.GetBootListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getBootListUseCase: GetBootListUseCase
): BaseViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    init {
        loadNews()
    }

    private val _bootListLoaded = MutableLiveData<List<BootCountLocal>>()
    val bootListLoaded: LiveData<List<BootCountLocal>> = _bootListLoaded


    private fun loadNews() {
        launch {
            try {
                _bootListLoaded.value = getBootListUseCase.getBootList()
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
            }
        }
    }
}