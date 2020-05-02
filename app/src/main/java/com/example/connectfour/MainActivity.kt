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
    fun clickstartgame(view:View){
            val gameplay = Intent(this,Gameplay::class.java)
            startActivity(gameplay)
    }
    fun clickplayersearch(view:View){
        val playersearch = Intent(this,PlayerConnect::class.java)
        startActivity(playersearch)
    }
    fun clickquit(view:View){
        super.onDestroy()
    }
}

