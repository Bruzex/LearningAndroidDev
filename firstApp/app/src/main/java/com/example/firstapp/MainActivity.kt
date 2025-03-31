package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lightButton = findViewById<Button>(R.id.lightBtn)
        val darkButton = findViewById<Button>(R.id.darkBtn)
        val linear = findViewById<LinearLayout>(R.id.linearLayout)
        val aboutMe = findViewById<TextView>(R.id.aboutMe);
        val switchActivity2 = findViewById<Button>(R.id.goToSecondActivity)

        lightButton.setOnClickListener {
            showToast("Switch to Light Mode")
            linear.setBackgroundResource(R.color.white)
            aboutMe.setTextColor(getColor(R.color.black))
            aboutMe.setBackgroundColor(getColor(R.color.white))
        }

        darkButton.setOnClickListener {
            showToast("Switch to Dark Mode")
            linear.setBackgroundResource(R.color.black)
            aboutMe.setTextColor(getColor(R.color.white))
            aboutMe.setBackgroundColor(getColor(R.color.black))
        }

        switchActivity2.setOnClickListener {
            showToast("Switching to Second Activity")
            intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(this.intent)
        }
    }

    private fun showToast(message : String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}