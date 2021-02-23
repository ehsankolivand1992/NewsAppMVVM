package com.example.newsappmvvm.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "source_table")
data class ModelSource(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "article_id")
    var articleId: Long,
    @ColumnInfo(name = "name")
    val name: String
)