package com.example.newsappmvvm.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSource
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.local.relations.ArticleAndSource


@Dao
interface NewsDao {


    fun insert(articleAndNews: ArticleAndNews) {
        val articles = articleAndNews.article
        val news = this.insert(articleAndNews.news)
        for (item in articles) {
            item.newsId = news
        }
        this.insert(articles)
    }

    fun insert(articleAndSource: ArticleAndSource, newsId: Long) {
        val source = articleAndSource.source
        val article = articleAndSource.article

        article.newsId = newsId

        val articleId = this.insert(article)
        source.articleId = articleId
        this.insert(source)
    }

    @Insert
    fun insertX(source: List<ModelSourceX>)


    @Insert
    fun insert(source: ModelSource): Long

    @Insert
    fun insert(article: ModelArticle): Long


    @Insert
    fun insert(article: List<ModelArticle>)

    @Insert
    fun insert(news: ModelNews): Long

    @Query("SELECT * FROM NEWS_TABLE")
    fun getAllNews(): ArticleAndNews


    @Query("SELECT * FROM article_table")
    fun getAllArticle(): List<ModelArticle>


    @Query("SELECT * FROM ARTICLE_TABLE")
    fun getAllArticleAndSource(): ArticleAndSource


    @Query("DELETE  FROM ARTICLE_TABLE")
    fun deleteAllArticles()

    @Query("SELECT * FROM source_x_table")
    fun getAllSources(): List<ModelSourceX>

    @Query("DELETE  FROM source_x_table")
    fun deleteAllSources()


}