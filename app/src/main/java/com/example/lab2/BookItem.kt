package com.example.lab2

data class Book(
    val name: String,
    val author: String,
    val creationYear: String,
    val rating: String,
    val id: Int
) {
}

fun booksCreate() : List<Book> = MutableList(20) { index ->
    Book(
        name = "Книга $index",
        author = "Автор: ",
        creationYear = "Год создания: ",
        rating = "0/10",
        id = index
    )
}