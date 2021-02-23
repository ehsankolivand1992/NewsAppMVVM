package com.example.newsappmvvm.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsappmvvm.data.NewsRepository
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.FragView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject



class EverythingViewModel @Inject constructor(private val  nr: NewsRepository): ViewModel(){


    lateinit var mainView: FragView


    fun setView(fragView: FragView)
    {
        this.mainView = fragView
    }



    fun setRecyclerView()
    {
        var test =  mainView.getText()
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                mainView.setData(nr.getAllNews(test))
            }
        }

    }




    class Factory @Inject constructor(val nr: NewsRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EverythingViewModel::class.java))
            {
                @Suppress("UNCHECKED_CAST")
                return EverythingViewModel(nr) as T
            }
            throw  IllegalArgumentException("Unable to construct ViewModel")

        }

    }



}

