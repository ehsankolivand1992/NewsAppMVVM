package com.example.newsappmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSource
import com.example.newsappmvvm.data.models.local.ModelSourceX

@Database(entities = [ModelArticle::class,ModelNews::class,ModelSource::class,ModelSourceX::class]
        ,version = 3,exportSchema = false)
abstract class NewsDatabase:RoomDatabase() {
    abstract fun getNewsDao():NewsDao
}