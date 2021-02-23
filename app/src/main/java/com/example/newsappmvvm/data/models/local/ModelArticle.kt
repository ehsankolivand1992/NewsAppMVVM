package com.example.newsappmvvm.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article_table")
data class ModelArticle(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "news_id")
    var newsId: Long,
    @ColumnInfo(name = "author")
    val author: String = "not",
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "url_to_image")
    val urlToImage: String
)