package com.example.lab2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.details_activity)

        //val id: Int = intent.getIntExtra("book_id", -1)
        val name = intent.getStringExtra("name")
        val author = intent.getStringExtra("author")
        val year = intent.getStringExtra("year")
        val rating = intent.getStringExtra("rating")

        this.findViewById<TextView>(R.id.Book_name).text = name.toString()
        this.findViewById<TextView>(R.id.author).text = author.toString()
        this.findViewById<TextView>(R.id.year).text = year.toString()
        this.findViewById<TextView>(R.id.rating).text = rating.toString()

        val backButton : ImageButton = findViewById<ImageButton>(R.id.Back_button)
        backButton.setOnClickListener() {
            closeDetails()
        }

        val searchButton : ImageButton = findViewById<ImageButton>(R.id.Search_button)
        searchButton.setOnClickListener() {
            searchInfo(name.toString())
        }
    }

    private fun searchInfo(name : String?){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ya.ru/search/?text=" + name))
        startActivity(intent)
    }

    private fun closeDetails() {
        this.finish()
    }
}