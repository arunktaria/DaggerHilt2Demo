package com.example.daggerhilt2demo

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmproject.DataModels.LoginRequestModel
import com.example.mvvmproject.DataModels.UserDataReposnse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val repositoryImpl: RetroHelper) :ViewModel(){
    lateinit var alertDialog:AlertDialog

    private val data=MutableLiveData<UserDataReposnse>()
    val tempdata:LiveData<UserDataReposnse>
    get() = data
    fun getLogins(user : LoginRequestModel,context: Context)
    {
        alertDialog=DialogLayout(context)
        alertDialog.create()
        alertDialog.show()


        viewModelScope.launch {
          val result = repositoryImpl.getLoginStatus(user)
        if (result.isSuccessful)
        {
           alertDialog.dismiss()
            data.postValue(result.body())
            Log.d("TAG", "in response ")
        }else
        {
            Log.d("TAG", "in error ")
        }
        }

    }





}