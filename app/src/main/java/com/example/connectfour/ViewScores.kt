package com.example.connectfour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_guest_name.*
import kotlinx.android.synthetic.main.activity_view_scores.*

class ViewScores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_scores)
        val intent2 = getIntent()
       val scoreplayer1  = intent2.getIntExtra("p1", 0)
       val scoreplayer2 = intent2.getIntExtra("p2", 0)
       score1.text="$scoreplayer1"
       score2.text="$scoreplayer2"
    }
    // Go back to Homepage Activity

    fun backtogameplay(view: View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }



}
