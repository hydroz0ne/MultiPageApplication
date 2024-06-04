package com.example.multi_pageapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutMLK : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_mlk)

        val backToMainButton = findViewById<Button>(R.id.backbutton)
        backToMainButton.setOnClickListener {
            finish()
        }
    }
}