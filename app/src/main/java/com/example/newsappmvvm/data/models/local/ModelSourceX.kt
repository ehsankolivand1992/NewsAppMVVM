package com.example.newsappmvvm.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "source_x_table")
data class ModelSourceX(
    @PrimaryKey(autoGenerate = true)
    val source_id: Long,
    val category: String,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
)