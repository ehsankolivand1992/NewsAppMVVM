package com.example.newsappmvvm.di

import com.example.newsappmvvm.MainActivity
import com.example.newsappmvvm.ui.fragments.EverythingFragment
import com.example.newsappmvvm.ui.fragments.HeadLineFragment
import com.example.newsappmvvm.ui.fragments.SourceFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun injectMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun provideHeadLineFragment(): HeadLineFragment

    @ContributesAndroidInjector
    internal abstract fun provideSourceFragment(): SourceFragment

    @ContributesAndroidInjector
    internal abstract fun provideTopicFragment(): EverythingFragment


}