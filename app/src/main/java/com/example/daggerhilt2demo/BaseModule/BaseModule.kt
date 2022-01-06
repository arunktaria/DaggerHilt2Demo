package com.example.daggerhilt2demo.BaseModule

import android.app.Application
import com.example.daggerhilt2demo.RepositoryImpl
import com.example.daggerhilt2demo.RetroHelper
import com.example.daggerhilt2demo.RetrofitApi
import com.example.mvvmproject.DataModels.LoginRequestModel
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
@HiltAndroidApp
class BaseModule : Application() {

    @Singleton
    @Provides
    fun getRetro() :RetrofitApi
    {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://35.80.198.152:9201/api/").build().create(RetrofitApi::class.java)
    }


    @Singleton
    @Provides
    fun getRepository(retro : RetrofitApi) : RetroHelper
    {
        return RepositoryImpl(retro)
    }


}