package com.example.narutocharlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import de.hdodenhof.circleimageview.CircleImageView

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        val photoLink: CircleImageView = findViewById(R.id.tv_photo_link)
        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            finish() // Menutup DetailCharacter Activity dan kembali ke MainActivity
        }
    }
}