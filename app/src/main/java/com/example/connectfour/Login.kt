package com.example.connectfour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        btngosignup.setOnClickListener() {
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }
        btnlogin.setOnClickListener {
            doLogin()
        }
    }

        private fun doLogin() {
            if (etemaillogin.text.toString().isEmpty()) {
                etemaillogin.error = "Please enter email"
                etemaillogin.requestFocus()
                return
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(etemaillogin.text.toString()).matches()) {
                etemaillogin.error = "Please enter valid email"
                etemaillogin.requestFocus()
                return
            }

            if (etpasslogin.text.toString().isEmpty()) {
                etpasslogin.error = "Please enter password"
                etpasslogin.requestFocus()
                return
            }
            auth.signInWithEmailAndPassword(etemaillogin.text.toString(),etpasslogin.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT)
                            .show()
                        updateUI(null)
                    }
                }
        }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            //startActivity(Intent())
            finish()
        } else {
            Toast.makeText(baseContext, "Login failed.", Toast.LENGTH_SHORT).show()
        }
    }
}
