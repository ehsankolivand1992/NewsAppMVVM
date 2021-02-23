package com.example.newsappmvvm.data

import com.example.newsappmvvm.data.dataSource.LocalDataSource
import com.example.newsappmvvm.data.dataSource.RemoteDataSource
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.local.relations.ArticleAndSource
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.utils.CheckNetworkState
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource,
    private val networkState: CheckNetworkState
) {

    private var articleAndNews: NewsModel? = null


    suspend fun getAllNews(query: String)
            : List<ModelArticle> {


        if (networkState.isOnline()) {
            articleAndNews = remoteDataSource.getEverything(query)
            this.deleteAllArticles()
            localDataSource.insert(networkState.ConvertModelRemoteToLocal(articleAndNews!!))

        }

        return localDataSource.getAllNews()

    }


    suspend fun getTopHeadLines(topic: String): List<ModelArticle> {
        if (networkState.isOnline()) {
            articleAndNews = remoteDataSource.getTopHeadLines(topic)
            this.deleteAllArticles()
            localDataSource.insert(networkState.ConvertModelRemoteToLocal(articleAndNews!!))
        }

        return localDataSource.getAllNews()
    }

    suspend fun getSource(): List<ModelSourceX> {
        if (networkState.isOnline()) {
            val sources = remoteDataSource.getSource()
            this.deleteAllSource()
            localDataSource.insert(networkState.ConvertModelRemoteToLocal(sources))

        }

        return localDataSource.getAllSources()
    }

    fun getAllArticleAndSource(): ArticleAndSource {
        return localDataSource.getAllArticleAndSource()
    }

    private fun deleteAllArticles() {
        localDataSource.deleteAllArticles()
    }

    private fun deleteAllSource() {
        localDataSource.deleteAllSources()
    }


    fun insert(articleAndSource: ArticleAndSource, newsId: Long) {
        localDataSource.insert(articleAndSource, newsId)
    }

    fun insert(articleAndNews: ArticleAndNews) {
        localDataSource.insert(articleAndNews)
    }

    fun insert(news: ModelNews): Long {
        return localDataSource.insert(news)
    }


}