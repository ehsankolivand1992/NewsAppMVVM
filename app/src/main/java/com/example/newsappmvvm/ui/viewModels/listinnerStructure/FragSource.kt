package com.example.newsappmvvm.ui.viewModels.listinnerStructure

import com.example.newsappmvvm.data.models.local.ModelSourceX

interface FragSource {
    fun setData(allNews: List<ModelSourceX>)
    fun getText(): String

}