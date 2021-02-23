package com.example.newsappmvvm.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news_table")
data class ModelNews(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "total_results")
    val totalResults: Int
)