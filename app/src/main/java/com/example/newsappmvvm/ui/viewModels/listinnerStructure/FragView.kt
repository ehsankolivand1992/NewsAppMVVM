package com.example.newsappmvvm.ui.viewModels.listinnerStructure

import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews

interface FragView {

    fun setData(allNews: List<ModelArticle>)
    fun getText():String

}