package com.example.movieapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "b7dd029d516bb97a87aecf814997c46b"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val IMAGE_URL = "https://image.tmdb.org/t/p/w342"

//Popular movies
//https://api.themoviedb.org/3/movie/popular?api_key=b7dd029d516bb97a87aecf814997c46b&page=1
//https://api.themoviedb.org/3/movie/popular?api_key=b7dd029d516bb97a87aecf814997c46b

//Top Rated movies
//https://api.themoviedb.org/3/movie/top_rated?api_key=b7dd029d516bb97a87aecf814997c46b&page=1
//https://api.themoviedb.org/3/movie/top_rated?api_key=b7dd029d516bb97a87aecf814997c46b

//Image movies
//https://image.tmdb.org/t/p/w342//6KErczPBROQty7QoIsaa6wJYXZi.jpg

object MovieClient {

    fun getClient(): MovieInterface{

        val requestInterceptor = Interceptor { chain ->
            // Interceptor take only one argument which is a lambda function so parenthesis can be omitted

            var url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            var request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request) //explicitly return a valur from whit @ annotation. Lambda always returns the valur of the
        }

        val okHttpclient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpclient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieInterface::class.java)

    }
}