package com.example.firstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goToHomeBtn = findViewById<Button>(R.id.goToHomeBtn)
        val openWebBtn = findViewById<Button>(R.id.openWeb)
        val openCameraBtn = findViewById<Button>(R.id.openCamera)

        goToHomeBtn.setOnClickListener {
            showToast("Switching to Home Screen")
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        openWebBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://sidharth-bhatla.netlify.app/")
            startActivity(intent)
        }

        openCameraBtn.setOnClickListener {
            val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            startActivity((intent))
        }
    }
    fun showToast(message : String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}