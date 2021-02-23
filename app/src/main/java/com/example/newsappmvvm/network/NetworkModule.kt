package com.example.newsappmvvm.network

import com.example.newsappmvvm.BuildConfig
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.data.models.remote.Sources
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Headers


interface NewsService{


    @Headers("apiKey: " + BuildConfig.API_KEY)
    @GET("top-headlines")
     suspend fun getTopHeadLines(@Query("q") sources: String):NewsModel



    @Headers("apiKey: " + BuildConfig.API_KEY)
    @GET("everything")
    suspend fun getEverything(@Query("q") topic: String): NewsModel



    @Headers("apiKey: " + BuildConfig.API_KEY)
    @GET("sources")
    suspend  fun getSource(): Sources



}




@Module
internal class NetworkModule{

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor{



        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return interceptor

    }



    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(CALL_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(
                Interceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .url(
                            chain.request()
                                .url
                                .newBuilder()
                                .addQueryParameter("apiKey", BuildConfig.API_KEY)
                                .build()
                        )
                        .build()
                    return@Interceptor chain.proceed(request)
                }
            )
            .build()
    }




    @Singleton
    @Provides
    fun retrofit(okh: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.News_WebService_URL)
            .client(okh)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()


    @Provides
    @Singleton
    fun newsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)




    companion object {
        private const val CALL_TIME_OUT_IN_MILLIS = 150000L
        private const val CONNECT_TIME_OUT_IN_MILLIS = 100000L
        private const val READ_TIME_OUT_IN_MILLIS = 300000L
        private const val WRITE_TIME_OUT_IN_MILLIS = 300000L
    }
}