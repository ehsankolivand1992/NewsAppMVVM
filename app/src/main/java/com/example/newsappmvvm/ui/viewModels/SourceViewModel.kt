package com.example.newsappmvvm.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsappmvvm.data.NewsRepository
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.FragSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SourceViewModel @Inject constructor(private val nr: NewsRepository) : ViewModel() {


    lateinit var fragView: FragSource


    fun setView(fragView: FragSource) {
        this.fragView = fragView
    }


    fun setRecyclerView() {
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                fragView.setData(nr.getSource())
            }
        }

    }


    class Factory @Inject constructor(val nr: NewsRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SourceViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SourceViewModel(nr) as T
            }
            throw  IllegalArgumentException("Unable to construct ViewModel")

        }

    }


}

