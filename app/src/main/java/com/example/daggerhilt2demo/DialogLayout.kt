package com.example.daggerhilt2demo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class DialogLayout( context: Context) : AlertDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progressdialog)
    }


}