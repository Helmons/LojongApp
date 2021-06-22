package com.provaandroid.lojongapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.provaandroid.lojongapp.domain.usecase.*

class LojongViewModelFactory(
    private val app: Application,
    private val getCheckinUseCase: GetCheckinUseCase,

): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LojongViewModel(
            app,
            getCheckinUseCase
        ) as T
    }
}
