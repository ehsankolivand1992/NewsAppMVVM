package com.example.newsappmvvm.data.dataSource

import com.example.newsappmvvm.data.database.RemoteDataSourceStructure
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.data.models.remote.Sources
import com.example.newsappmvvm.network.NewsService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val news: NewsService) : RemoteDataSourceStructure {


    // sources is topic that user want to know about it for example tech or apple or etc
    override suspend fun getTopHeadLines(sources: String): NewsModel {

        return news.getTopHeadLines(sources)
    }


    override suspend fun getEverything(topic: String): NewsModel {
        return news.getEverything(topic)


    }

    override suspend fun getSource(): Sources {
        return news.getSource()


    }


}