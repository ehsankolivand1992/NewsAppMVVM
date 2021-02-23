package com.example.newsappmvvm.data.models.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews

data class ArticleAndNews(
    @Embedded val news: ModelNews,
    @Relation(
        parentColumn = "id",
        entityColumn = "news_id",
        entity = ModelArticle::class,
        associateBy = Junction(ModelArticle::class),
    )
    val article: List<ModelArticle>

)




