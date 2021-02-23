package com.example.newsappmvvm.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsappmvvm.data.NewsRepository
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.FragView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class HeadLineViewModel @Inject constructor(private val  nr: NewsRepository): ViewModel(){




    lateinit var fragView: FragView


    fun setView(fragView: FragView)
    {
      this.fragView = fragView
    }




    fun setRecyclerView()
    {
        var test = fragView.getText()
        viewModelScope.launch {
            withContext(Dispatchers.IO)
            {
                fragView.setData(nr.getTopHeadLines(test))
            }
        }

    }


    class Factory @Inject constructor(val nr: NewsRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HeadLineViewModel::class.java))
            {
                @Suppress("UNCHECKED_CAST")
                return HeadLineViewModel(nr) as T
            }
            throw  IllegalArgumentException("Unable to construct ViewModel")

        }

    }



}

