package com.example.post_kotlin.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.post_kotlin.repazitori.Repazitori

class MainVievModelProvider(private val repazitori: Repazitori):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
     return MainVievModel(repazitori) as T
    }
}