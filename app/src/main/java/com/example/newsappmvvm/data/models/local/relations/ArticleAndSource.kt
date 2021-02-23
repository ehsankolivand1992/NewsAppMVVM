package com.example.newsappmvvm.data.models.local.relations

import androidx.room.Embedded
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelSource
import androidx.room.Relation

data class ArticleAndSource(
@Embedded val article: ModelArticle,
@Relation(
        parentColumn = "id",
        entityColumn = "article_id"
)
        val source: ModelSource
)