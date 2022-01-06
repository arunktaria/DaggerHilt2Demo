package com.example.daggerhilt2demo

import com.example.mvvmproject.DataModels.LoginRequestModel
import com.example.mvvmproject.DataModels.UserDataReposnse
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val retrofitApi: RetrofitApi): RetroHelper {

    override suspend fun getLoginStatus(user: LoginRequestModel): Response<UserDataReposnse> {
        return retrofitApi.getLoginStatus(user)
    }

}