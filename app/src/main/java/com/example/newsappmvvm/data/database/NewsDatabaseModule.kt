package com.example.newsappmvvm.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class NewsDatabaseModule {

    companion object {

        @Singleton
        @Provides
        fun provideDb(context: Context) = Room.databaseBuilder(
            context.applicationContext, NewsDatabase::class.java, "news_db"
        )
            .allowMainThreadQueries().build()


        @Singleton
        @Provides
        fun provideNewsDao(db: NewsDatabase) = db.getNewsDao()
    }


}