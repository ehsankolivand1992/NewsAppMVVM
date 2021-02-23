package com.example.newsappmvvm.utils

import android.content.Context
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.data.models.remote.SourceX
import com.example.newsappmvvm.data.models.remote.Sources
import kotlinx.coroutines.flow.Flow

interface CheckNetworkState {

    fun ConvertModelRemoteToLocal(newsModel: NewsModel):ArticleAndNews
    fun ConvertModelRemoteToLocal(modelSourceX: Sources):List<ModelSourceX>

    fun isOnline():Boolean
}