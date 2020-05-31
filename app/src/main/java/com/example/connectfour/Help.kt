package com.example.connectfour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Help : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }
    // Takes you back to MainActivity
    fun clickgoback(view: View){
        val playersearch = Intent(this,MainActivity::class.java)
        startActivity(playersearch)
    }
}
