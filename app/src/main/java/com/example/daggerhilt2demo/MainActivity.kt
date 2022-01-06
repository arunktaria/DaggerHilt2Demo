package com.example.daggerhilt2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.daggerhilt2demo.databinding.ActivityMainBinding
import com.example.mvvmproject.DataModels.LoginRequestModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
    val viewmodel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener {

            val ob = LoginRequestModel(
                binding.emailedittext.text.toString(),
                binding.passwordedittext.text.toString(), "patient", "dsfsd54",
                "android",
                "1.1",
                "android"
            )

            viewmodel.getLogins(ob,MainActivity@this)

        }

        viewmodel.tempdata.observe(this, Observer {
            Log.d("TAG", "onCreate: "+it.data?.first_name)
            Toast.makeText(this,it.data?.email.toString(),Toast.LENGTH_SHORT).show()

        })



    }
}