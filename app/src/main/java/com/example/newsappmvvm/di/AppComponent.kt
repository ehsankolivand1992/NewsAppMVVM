package com.example.newsappmvvm.di

import android.app.Application
import com.example.newsappmvvm.data.database.NewsDatabaseModule
import com.example.newsappmvvm.network.NetworkModule
import com.example.newsappmvvm.root.BaseApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NewsDatabaseModule::class,
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        NetworkModule::class]
)
interface AppComponent : AndroidInjector<BaseApp> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}