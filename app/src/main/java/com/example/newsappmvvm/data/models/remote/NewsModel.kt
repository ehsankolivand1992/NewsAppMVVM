package com.example.newsappmvvm.data.models.remote


data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
