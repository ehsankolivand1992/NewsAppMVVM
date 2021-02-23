package com.example.newsappmvvm.ui.viewModels.listinnerStructure

import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews

interface MainView {
    fun getTargetName(): String
    fun setRecyclerViewData(news: ArticleAndNews)

    fun showProgressDialog()

    fun dismissProgressDialog()

    fun refreshRecyclerView()


}