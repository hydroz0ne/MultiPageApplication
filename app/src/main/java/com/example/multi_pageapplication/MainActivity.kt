package com.example.multi_pageapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuButton = findViewById<Button>(R.id.button)
        val forlaterButton = findViewById<Button>(R.id.button2)
        val aboutUsButton = findViewById<Button>(R.id.button3)

        menuButton.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }

        forlaterButton.setOnClickListener {
            val intent = Intent(this, ForLater::class.java)
            startActivity(intent)
        }

        aboutUsButton.setOnClickListener {
            val intent = Intent(this, AboutMLK::class.java)
            startActivity(intent)
        }
    }
}