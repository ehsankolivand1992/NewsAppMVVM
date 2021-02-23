package com.example.newsappmvvm.data.database

import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.local.relations.ArticleAndSource
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.data.models.remote.Sources


interface LocalDataSourceStructure {

    fun insert(articleAndSource: ArticleAndSource, newsId: Long)
    fun insert(articleAndNews: ArticleAndNews)
    fun insert(news: ModelNews): Long
    fun getAllArticleAndSource(): ArticleAndSource
    fun getAllNews(): List<ModelArticle>
    fun getAllSources(): List<ModelSourceX>
    fun deleteAllSources()
    fun deleteAllArticles()
    fun insert(modelSourceX: List<ModelSourceX>)


}

interface RemoteDataSourceStructure {


    suspend fun getTopHeadLines(sources: String): NewsModel
    suspend fun getEverything(topic: String): NewsModel
    suspend fun getSource(): Sources


}