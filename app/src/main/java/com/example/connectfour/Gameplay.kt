package com.example.connectfour

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.recreate
import kotlinx.android.synthetic.main.activity_gameplay.*


class Gameplay : AppCompatActivity() {
    var scorePlayer1 = 0
    var scorePlayer2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)
        // create object, and data from intent
        val intent2: Intent = getIntent()
        // Get player names from previous activity
        val p1name: String = intent2.getStringExtra("p1name")
        val p2name: String = intent2.getStringExtra("p2name")
        p1tv.text = "$p1name"
        p2tv.text = "$p2name"

    }

    // Takes user to the ViewScores activity
    fun previewscore(view: View) {
        val playersearch = Intent(this, ViewScores::class.java)
        playersearch.putExtra("p1", scorePlayer1)
        playersearch.putExtra("p2", scorePlayer2)
        startActivity(playersearch)
    }


    // Reset game, Play again
    fun resetGame(view: View){
        iv1.setImageResource(R.drawable.ic_launcher_foreground)
        iv2.setImageResource(R.drawable.ic_launcher_foreground)
        iv3.setImageResource(R.drawable.ic_launcher_foreground)
        iv4.setImageResource(R.drawable.ic_launcher_foreground)
        iv5.setImageResource(R.drawable.ic_launcher_foreground)
        iv6.setImageResource(R.drawable.ic_launcher_foreground)
        iv7.setImageResource(R.drawable.ic_launcher_foreground)
        iv8.setImageResource(R.drawable.ic_launcher_foreground)
        iv9.setImageResource(R.drawable.ic_launcher_foreground)
        iv10.setImageResource(R.drawable.ic_launcher_foreground)
        iv11.setImageResource(R.drawable.ic_launcher_foreground)
        iv12.setImageResource(R.drawable.ic_launcher_foreground)
        iv13.setImageResource(R.drawable.ic_launcher_foreground)
        iv14.setImageResource(R.drawable.ic_launcher_foreground)
        iv15.setImageResource(R.drawable.ic_launcher_foreground)
        iv16.setImageResource(R.drawable.ic_launcher_foreground)
        iv17.setImageResource(R.drawable.ic_launcher_foreground)
        iv18.setImageResource(R.drawable.ic_launcher_foreground)
        iv19.setImageResource(R.drawable.ic_launcher_foreground)
        iv20.setImageResource(R.drawable.ic_launcher_foreground)
        iv21.setImageResource(R.drawable.ic_launcher_foreground)
        iv22.setImageResource(R.drawable.ic_launcher_foreground)
        iv23.setImageResource(R.drawable.ic_launcher_foreground)
        iv24.setImageResource(R.drawable.ic_launcher_foreground)
        iv25.setImageResource(R.drawable.ic_launcher_foreground)
        iv26.setImageResource(R.drawable.ic_launcher_foreground)
        iv27.setImageResource(R.drawable.ic_launcher_foreground)
        iv28.setImageResource(R.drawable.ic_launcher_foreground)
        iv29.setImageResource(R.drawable.ic_launcher_foreground)
        iv30.setImageResource(R.drawable.ic_launcher_foreground)

    // Player was not able to play again until we added the .clear
        player1.clear()
        player2.clear()

        iv1.isEnabled = true
        iv2.isEnabled = true
        iv3.isEnabled = true
        iv4.isEnabled = true
        iv5.isEnabled = true
        iv6.isEnabled = true
        iv7.isEnabled = true
        iv8.isEnabled = true
        iv9.isEnabled = true
        iv10.isEnabled = true
        iv11.isEnabled = true
        iv12.isEnabled = true
        iv13.isEnabled = true
        iv14.isEnabled = true
        iv15.isEnabled = true
        iv16.isEnabled = true
        iv17.isEnabled = true
        iv18.isEnabled = true
        iv19.isEnabled = true
        iv20.isEnabled = true
        iv21.isEnabled = true
        iv22.isEnabled = true
        iv23.isEnabled = true
        iv24.isEnabled = true
        iv25.isEnabled = true
        iv26.isEnabled = true
        iv27.isEnabled = true
        iv28.isEnabled = true
        iv29.isEnabled = true
        iv30.isEnabled = true



    }
    // When clicking on the cell, it will occupy the color of the player
    fun ivClick(view: View){
        val ivSelected = view as ImageView
        var cellID = 0
        when(ivSelected.id){
            R.id.iv1 -> cellID = 1
            R.id.iv2 -> cellID = 2
            R.id.iv3 -> cellID = 3
            R.id.iv4 -> cellID = 4
            R.id.iv5 -> cellID = 5
            R.id.iv6 -> cellID = 6
            R.id.iv7 -> cellID = 7
            R.id.iv8 -> cellID = 8
            R.id.iv9 -> cellID = 9
            R.id.iv10 -> cellID = 10
            R.id.iv11 -> cellID = 11
            R.id.iv12 -> cellID = 12
            R.id.iv13 -> cellID = 13
            R.id.iv14 -> cellID = 14
            R.id.iv15 -> cellID = 15
            R.id.iv16 -> cellID = 16
            R.id.iv17 -> cellID = 17
            R.id.iv18 -> cellID = 18
            R.id.iv19 -> cellID = 19
            R.id.iv20 -> cellID = 20
            R.id.iv21 -> cellID = 21
            R.id.iv22 -> cellID = 22
            R.id.iv23 -> cellID = 23
            R.id.iv24 -> cellID = 24
            R.id.iv25 -> cellID = 25
            R.id.iv26 -> cellID = 26
            R.id.iv27 -> cellID = 27
            R.id.iv28 -> cellID = 28
            R.id.iv29 -> cellID = 29
            R.id.iv30 -> cellID = 30

        }
        playGame(cellID,ivSelected)
    }
    // array list used to store whatever the user clicks, checkwinner() will come back to this
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    // decides which color is to place depending on the player
    fun playGame(cellID: Int, ivSelected: ImageView) {
        if(activePlayer==1){
            ivSelected.setImageResource(R.drawable.red2)
            ivSelected.isEnabled = false
            player1.add(cellID)
            activePlayer = 2
        }else{
            ivSelected.setImageResource(R.drawable.yellow2)
            ivSelected.isEnabled = false
            player2.add(cellID)
            activePlayer = 1
        }
        // checks if player wins on each turn
        checkWinner(ivSelected)
    }
    //checks for winner if statements
    fun checkWinner(ivSelected: ImageView) {
        var winner = -1

        //row1 player1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) && player1.contains(4)) {
            winner = 1
        }
        if (player1.contains(2) && player1.contains(3) && player1.contains(4) && player1.contains(5)) {
            winner = 1
        }
        if (player1.contains(3) && player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        //row1 player2
        if (player2.contains(1) && player2.contains(2) && player2.contains(3) && player2.contains(4)) {
            winner = 2
        }
        if (player2.contains(2) && player2.contains(3) && player2.contains(4) && player2.contains(5)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        // row 2 player 1

        if (player1.contains(7) && player1.contains(8) && player1.contains(9) && player1.contains(10)) {
            winner = 1
        }
        if (player1.contains(8) && player1.contains(9) && player1.contains(10) && player1.contains(11)) {
            winner = 1
        }
        if (player1.contains(9) && player1.contains(10) && player1.contains(11) && player1.contains(12)) {
            winner = 1
        }
        //row 2 player 2
        if (player2.contains(7) && player2.contains(8) && player2.contains(9) && player2.contains(10)) {
            winner = 2
        }
        if (player2.contains(8) && player2.contains(9) && player2.contains(10) && player2.contains(11)) {
            winner = 2
        }
        if (player2.contains(9) && player2.contains(10) && player2.contains(11) && player2.contains(12)) {
            winner = 2
        }

        // row 3 player 1
        if (player1.contains(13) && player1.contains(14) && player1.contains(15) && player1.contains(16)) {
            winner = 1
        }
        if (player1.contains(14) && player1.contains(15) && player1.contains(16) && player1.contains(17)) {
            winner = 1
        }
        if (player1.contains(15) && player1.contains(16) && player1.contains(17) && player1.contains(18)) {
            winner = 1
        }
        // row 3 player 2
        if (player2.contains(13) && player2.contains(14) && player2.contains(15) && player2.contains(16)) {
            winner = 2
        }
        if (player2.contains(14) && player2.contains(15) && player2.contains(16) && player2.contains(17)) {
            winner = 2
        }
        if (player2.contains(15) && player2.contains(16) && player2.contains(17) && player2.contains(18)) {
            winner = 2
        }
        // row 4 player 1
        if (player1.contains(19) && player1.contains(20) && player1.contains(21) && player1.contains(22) ) {
            winner = 1
        }
        if (player1.contains(20) && player1.contains(21) && player1.contains(22) && player1.contains(23)) {
            winner = 1
        }
        if (player1.contains(21) && player1.contains(22) && player1.contains(23) && player1.contains(24) ) {
            winner = 1
        }
        // row 4 player 2
        if (player2.contains(19) && player2.contains(20) && player2.contains(21) && player2.contains(22) ) {
            winner = 2
        }
        if (player2.contains(20) && player2.contains(21) && player2.contains(22) && player2.contains(23)) {
            winner = 2
        }
        if (player2.contains(21) && player2.contains(22) && player2.contains(23) && player2.contains(24) ) {
            winner = 2
        }
        // row 5 player 1
        if (player1.contains(25) && player1.contains(26) && player1.contains(27) && player1.contains(28) ) {
            winner = 1
        }
        if (player1.contains(26) && player1.contains(27) && player1.contains(28) && player1.contains(29)) {
            winner = 1
        }
        if (player1.contains(27) && player1.contains(28) && player1.contains(29) && player1.contains(30) ) {
            winner = 1
        }
        // row 5 player 2
        if (player2.contains(25) && player2.contains(26) && player2.contains(27) && player2.contains(28) ) {
            winner = 2
        }
        if (player2.contains(26) && player2.contains(27) && player2.contains(28) && player2.contains(29)) {
            winner = 2
        }
        if (player2.contains(27) && player2.contains(28) && player2.contains(29) && player2.contains(30) ) {
            winner = 2
        }
        // cols player 1

        if (player1.contains(1) && player1.contains(7) && player1.contains(13) && player1.contains(19)) {
            winner = 1
        }
        if (player1.contains(7) && player1.contains(13) && player1.contains(19) && player1.contains(25)) {
            winner = 1
        }
        if (player1.contains(2) && player1.contains(8) && player1.contains(14) && player1.contains(20)) {
            winner = 1
        }
        if (player1.contains(8) && player1.contains(14) && player1.contains(20) && player1.contains(26)) {
            winner = 1
        }
        if (player1.contains(3) && player1.contains(9) && player1.contains(15) && player1.contains(21)) {
            winner = 1
        }
        if (player1.contains(9) && player1.contains(15) && player1.contains(21) && player1.contains(27)) {
            winner = 1
        }
        if (player1.contains(4) && player1.contains(10) && player1.contains(16) && player1.contains(22)) {
            winner = 1
        }
        if (player1.contains(10) && player1.contains(16) && player1.contains(22) && player1.contains(28)) {
            winner = 1
        }
        if (player1.contains(5) && player1.contains(11) && player1.contains(17) && player1.contains(23)) {
            winner = 1
        }
        if (player1.contains(11) && player1.contains(17) && player1.contains(23) && player1.contains(19)) {
            winner = 1
        }
        if (player1.contains(6) && player1.contains(12) && player1.contains(18) && player1.contains(24)) {
            winner = 1
        }
        if (player1.contains(12) && player1.contains(18) && player1.contains(24) && player1.contains(30)) {
            winner = 1
        }
        //col player2

        if (player2.contains(1) && player2.contains(7) && player2.contains(13) && player2.contains(19)) {
            winner = 2
        }
        if (player2.contains(7) && player2.contains(13) && player2.contains(19) && player2.contains(25)) {
            winner = 2
        }
        if (player2.contains(2) && player2.contains(8) && player2.contains(14) && player2.contains(20)) {
            winner = 2
        }
        if (player2.contains(8) && player2.contains(14) && player2.contains(20) && player2.contains(26)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(9) && player2.contains(15) && player2.contains(21)) {
            winner = 2
        }
        if (player2.contains(9) && player2.contains(15) && player2.contains(21) && player2.contains(27)) {
            winner = 2
        }
        if (player2.contains(4) && player2.contains(10) && player2.contains(16) && player2.contains(22)) {
            winner = 2
        }
        if (player2.contains(10) && player2.contains(16) && player2.contains(22) && player2.contains(28)) {
            winner = 2
        }
        if (player2.contains(5) && player2.contains(11) && player2.contains(17) && player2.contains(23)) {
            winner = 2
        }
        if (player2.contains(11) && player2.contains(17) && player2.contains(23) && player2.contains(29)) {
            winner = 2
        }
        if (player2.contains(6) && player2.contains(12) && player2.contains(18) && player2.contains(24)) {
            winner = 2
        }
        if (player2.contains(12) && player2.contains(18) && player2.contains(24) && player2.contains(30)) {
            winner = 2
        }

        //diagonal player 1
        if (player1.contains(4) && player1.contains(9) && player1.contains(14) && player1.contains(19)) {
            winner = 1
        }
        if (player1.contains(5) && player1.contains(10) && player1.contains(15) && player1.contains(20)) {
            winner = 1
        }
        if (player1.contains(10) && player1.contains(15) && player1.contains(20) && player1.contains(25)) {
            winner = 1
        }
        if (player1.contains(6) && player1.contains(11) && player1.contains(16) && player1.contains(21)) {
            winner = 1
        }
        if (player1.contains(11) && player1.contains(16) && player1.contains(21) && player1.contains(26)) {
            winner = 1
        }
        if (player1.contains(12) && player1.contains(17) && player1.contains(22) && player1.contains(27)) {
            winner = 1
        }
        if (player1.contains(3) && player1.contains(10) && player1.contains(17) && player1.contains(24)) {
            winner = 1
        }
        if (player1.contains(2) && player1.contains(9) && player1.contains(16) && player1.contains(23)) {
            winner = 1
        }
        if (player1.contains(9) && player1.contains(16) && player1.contains(23) && player1.contains(30)) {
            winner = 1
        }
        if (player1.contains(1) && player1.contains(8) && player1.contains(15) && player1.contains(22)) {
            winner = 1
        }
        if (player1.contains(8) && player1.contains(15) && player1.contains(22) && player1.contains(29)) {
            winner = 1
        }
        if (player1.contains(7) && player1.contains(14) && player1.contains(21) && player1.contains(28)) {
            winner = 1
        }

        // diagonal player 2
        if (player2.contains(4) && player2.contains(9) && player2.contains(14) && player2.contains(19)) {
            winner = 2
        }
        if (player2.contains(5) && player2.contains(10) && player2.contains(15) && player2.contains(20)) {
            winner = 2
        }
        if (player2.contains(10) && player2.contains(15) && player2.contains(20) && player2.contains(25)) {
            winner = 2
        }
        if (player2.contains(6) && player2.contains(11) && player2.contains(16) && player2.contains(21)) {
            winner = 2
        }
        if (player2.contains(11) && player2.contains(16) && player2.contains(21) && player2.contains(26)) {
            winner = 2
        }
        if (player2.contains(12) && player2.contains(17) && player2.contains(22) && player2.contains(27)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(10) && player2.contains(17) && player2.contains(24)) {
            winner = 2
        }
        if (player2.contains(2) && player2.contains(9) && player2.contains(16) && player2.contains(23)) {
            winner = 2
        }
        if (player2.contains(9) && player2.contains(16) && player2.contains(23) && player2.contains(30)) {
            winner = 2
        }
        if (player2.contains(1) && player2.contains(8) && player2.contains(15) && player2.contains(22)) {
            winner = 2
        }
        if (player2.contains(8) && player2.contains(15) && player2.contains(22) && player2.contains(29)) {
            winner = 2
        }
        if (player2.contains(7) && player2.contains(14) && player2.contains(21) && player2.contains(28)) {
            winner = 2
        }



    // User will not be able to place anymore coins after winning, until user hits "Play Again" button
        fun stopTouch(){
            iv1.isEnabled = false
            iv2.isEnabled = false
            iv3.isEnabled = false
            iv4.isEnabled = false
            iv5.isEnabled = false
            iv6.isEnabled = false
            iv7.isEnabled = false
            iv8.isEnabled = false
            iv9.isEnabled = false
            iv10.isEnabled = false
            iv11.isEnabled = false
            iv12.isEnabled = false
            iv13.isEnabled = false
            iv14.isEnabled = false
            iv15.isEnabled = false
            iv16.isEnabled = false
            iv17.isEnabled = false
            iv18.isEnabled = false
            iv19.isEnabled = false
            iv20.isEnabled = false
            iv21.isEnabled = false
            iv22.isEnabled = false
            iv23.isEnabled = false
            iv24.isEnabled = false
            iv25.isEnabled = false
            iv26.isEnabled = false
            iv27.isEnabled = false
            iv28.isEnabled = false
            iv29.isEnabled = false
            iv30.isEnabled = false
        }




    // Displays toast for winner whether its player1 or player2

        if (winner != -1) {
            if (winner == 1) {

                Toast.makeText(this, " Player 1  won the game", Toast.LENGTH_LONG).show()
                stopTouch() //Disables play
                 var sr1= scorePlayer1++
                 //score1.text=sr1.toString()
            } else {

                Toast.makeText(this, " Player 2  won the game", Toast.LENGTH_LONG).show()
                stopTouch() //Disables play
                var sr2= scorePlayer2++
                //score2.text=sr2.toString()
            }
        }

    }

}

