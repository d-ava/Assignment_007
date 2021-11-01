package com.example.assignment_007

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress ("UNCHECKED_CAST")
class MainActivityViewModelFactory(var context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityModel::class.java)){
            return MainActivityModel(context) as T
        }
        throw IllegalArgumentException("viewmodel not found")
    }
}