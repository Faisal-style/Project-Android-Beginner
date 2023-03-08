package com.example.narutocharlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailCharacter : AppCompatActivity() {

    companion object {
        const val CHARACTER_NAME = "CHARACTER_NAME"
        const val CHARACTER_DESCRIPTION = "CHARACTER_DESCRIPTION"
        const val CHARACTER_PHOTO = "CHARACTER_PHOTO"
        const val CHARACTER_BACKGROUND = "CHARACTER_BACKGROUND"
    }

    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var background: TextView
    private lateinit var photo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

        name = findViewById(R.id.tv_name_character)
        description = findViewById(R.id.tv_description_character)
        photo = findViewById(R.id.tv_photo_link)
        background = findViewById(R.id.background_detail)


        val intent = intent
        val characterName = intent.getStringExtra(CHARACTER_NAME)
        val characterDescription = intent.getStringExtra(CHARACTER_DESCRIPTION)
        val characterPhotoUrl = intent.getStringExtra(CHARACTER_PHOTO)
        val characterBackground = intent.getStringExtra(CHARACTER_BACKGROUND)

        name.text = characterName
        description.text = characterDescription
        background.text = characterBackground
        Glide.with(this)
            .load(characterPhotoUrl)
            .into(photo)

        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            finish() // Menutup DetailCharacter Activity dan kembali ke MainActivity
        }
    }
}