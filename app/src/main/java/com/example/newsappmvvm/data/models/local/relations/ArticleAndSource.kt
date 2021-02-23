package com.example.newsappmvvm.data.models.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelSource

data class ArticleAndSource(
    @Embedded val article: ModelArticle,
    @Relation(
        parentColumn = "id",
        entityColumn = "article_id"
    )
    val source: ModelSource
)