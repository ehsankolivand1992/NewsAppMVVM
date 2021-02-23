package com.example.newsappmvvm.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsappmvvm.data.NewsRepository
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.MainView
import javax.inject.Inject

class MainViewModel @Inject constructor(private val nr: NewsRepository) : ViewModel() {


    lateinit var mainView: MainView


    fun setView(fragView: MainView) {
        this.mainView = fragView
    }


    fun setRecyclerView() {

    }


    class Factory @Inject constructor(val nr: NewsRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(nr) as T
            }
            throw  IllegalArgumentException("Unable to construct ViewModel")

        }

    }


}

