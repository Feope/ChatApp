package com.example.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Settings : AppCompatActivity() {
    private lateinit var email: TextView

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        email = findViewById(R.id.email)
        supportActionBar?.apply {
            title="Settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val currentUser = intent.getParcelableExtra<FirebaseUser>("currentUser")
        email.text = currentUser?.email
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun signOut(view: View) {
        FirebaseAuth.getInstance().signOut()
        email.text=""
    }
}