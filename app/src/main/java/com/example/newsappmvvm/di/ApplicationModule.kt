package com.example.newsappmvvm.di

import android.app.Application
import android.content.Context
import com.example.newsappmvvm.utils.CheckNetworkState
import com.example.newsappmvvm.utils.NetworkState
import dagger.Binds
import dagger.Module


@Module
abstract class ApplicationModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context

    @Binds
    internal abstract fun bindNetwork(ns: NetworkState): CheckNetworkState
}