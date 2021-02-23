package com.example.newsappmvvm.utils

import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.data.models.remote.Sources

interface CheckNetworkState {

    fun ConvertModelRemoteToLocal(newsModel: NewsModel): ArticleAndNews
    fun ConvertModelRemoteToLocal(modelSourceX: Sources): List<ModelSourceX>

    fun isOnline(): Boolean
}