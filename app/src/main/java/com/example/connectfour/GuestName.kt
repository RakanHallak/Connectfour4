package com.example.connectfour

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_guest_name.*

class GuestName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_name)
    }
    fun gnsubmit(view: View){
        // collect data from edit text
        val p1info= etplayer1.text.toString()
        val p2info = etplayer2.text.toString()
        // start activity and pass data
        val intent = Intent(this, Gameplay::class.java)
        intent.putExtra("p1name",p1info)
        intent.putExtra("p2name",p2info)
        startActivity(intent)
    }
}
