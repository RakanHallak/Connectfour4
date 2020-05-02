package com.example.connectfour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()
        btnsignup.setOnClickListener {
            signUpUser()
        }

    }

        private fun signUpUser() {
            if (etemailsignup.text.toString().isEmpty()) {
                etemailsignup.error = "Please enter email"
                etemailsignup.requestFocus()
                return
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(etemailsignup.text.toString()).matches()) {
                etemailsignup.error = "Please enter valid email"
                etemailsignup.requestFocus()
                return
            }

            if (etpasssignup.text.toString().isEmpty()) {
                etpasssignup.error = "Please enter password"
                etpasssignup.requestFocus()
                return
            }

            auth.createUserWithEmailAndPassword(
                etemailsignup.text.toString(),
                etpasssignup.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    //pbsignup.visibility = VISIBLE
                    if (task.isSuccessful) {
                        startActivity(Intent(this, Login::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            baseContext, "Sign Up failed. Try again after some time.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
}

