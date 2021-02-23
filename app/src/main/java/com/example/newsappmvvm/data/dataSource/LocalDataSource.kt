package com.example.newsappmvvm.data.dataSource

import com.example.newsappmvvm.data.database.LocalDataSourceStructure
import com.example.newsappmvvm.data.database.NewsDao
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.local.relations.ArticleAndSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: NewsDao): LocalDataSourceStructure {



    override  fun getAllNews(): List<ModelArticle> {

       return dao.getAllArticle()

    }

    override fun getAllArticleAndSource(): ArticleAndSource {

       return dao.getAllArticleAndSource()

    }


    override fun getAllSources(): List<ModelSourceX> {
        return dao.getAllSources()
    }





    override fun insert(articleAndSource: ArticleAndSource, newsId: Long) {
        dao.insert(articleAndSource,newsId)
    }

    // ArticleAndNews contain a ModelNews List<ModelArticle> one by many
    override fun insert(articleAndNews: ArticleAndNews) {
        dao.insert(articleAndNews)
    }


    override fun insert(news: ModelNews): Long {
        return dao.insert(news)
    }

    override fun insert(modelSourceX: List<ModelSourceX>) {
        dao.insertX(modelSourceX)
    }


    override fun deleteAllArticles() {
        dao.deleteAllArticles()
    }

    override fun deleteAllSources() {
        dao.deleteAllSources()
    }
}