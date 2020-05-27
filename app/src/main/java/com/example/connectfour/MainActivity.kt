package com.example.connectfour

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clickstart(view:View){
            val intent = Intent(this,GuestName::class.java)
            startActivity(intent)
    }
    fun clickhelp(view:View){
        val playersearch = Intent(this,Help::class.java)
        startActivity(playersearch)
    }
    fun clickquit(view:View){
        super.onDestroy()
    }
}

