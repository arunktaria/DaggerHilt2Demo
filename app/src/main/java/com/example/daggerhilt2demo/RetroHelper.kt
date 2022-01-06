package com.example.daggerhilt2demo

import com.example.mvvmproject.DataModels.LoginRequestModel
import com.example.mvvmproject.DataModels.UserDataReposnse
import retrofit2.Response

interface RetroHelper {
    suspend fun getLoginStatus(user :LoginRequestModel) : Response<UserDataReposnse>
}