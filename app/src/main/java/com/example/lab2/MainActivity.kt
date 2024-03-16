package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.list)
        val adapter = BooksAdapter(booksCreate(), this::onBookItemClicked)
        list.adapter = adapter
    }

    private fun onBookItemClicked(items: List<String>) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("name", items[0])
        intent.putExtra("author", items[1])
        intent.putExtra("year", items[2])
        intent.putExtra("rating", items[3])
        startActivity(intent)
    }

}