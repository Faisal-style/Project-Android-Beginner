package com.example.narutocharlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.ListCharacterAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacter: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCharacter = findViewById(R.id.rv_character)
        rvCharacter.setHasFixedSize(true)
        list.addAll(getListCharacter())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                val intent = Intent(this, AboutMe::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCharacter(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val charBackground = resources.getStringArray(R.array.character_background)
        val listCharacter = ArrayList<Character>()
        for (i in dataName.indices) {
            val hero = Character(dataName[i], dataDescription[i], dataPhoto[i], charBackground[i])
            listCharacter.add(hero)
        }
        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list)
        rvCharacter.adapter = listCharacterAdapter
    }
}