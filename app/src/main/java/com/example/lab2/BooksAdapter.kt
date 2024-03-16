package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter(private val allBooks: List<Book>,
                   private val onItemClicked: (item: List<String>) -> Unit,
): RecyclerView.Adapter<BookViewHolder>() {

    private fun onViewHolderClicked(viewItemBook: View) {
        val bookProperties : List<String> = listOf(
            viewItemBook.findViewById<TextView>(R.id.Book_name).text.toString(),
            viewItemBook.findViewById<TextView>(R.id.author).text.toString(),
            viewItemBook.findViewById<TextView>(R.id.year).text.toString(),
            viewItemBook.findViewById<TextView>(R.id.rating).text.toString())
        onItemClicked(bookProperties)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BookViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return BookViewHolder(view, this::onViewHolderClicked)
    }

    override fun getItemCount(): Int {
        return allBooks.size
    }

    override fun onBindViewHolder(
        holder: BookViewHolder, position: Int
    ) {
        holder.bind(allBooks[position])
    }
}


class BookViewHolder(itemView: View, private val onItemClicked: (View) -> Unit
): RecyclerView.ViewHolder(itemView) {

    private val nameView: TextView =
        itemView.findViewById(R.id.Book_name)
    private val authorView: TextView =
        itemView.findViewById(R.id.author)
    private val yearView: TextView =
        itemView.findViewById(R.id.year)
    private val ratingView: TextView =
        itemView.findViewById(R.id.rating)
    private val pictureView: ImageView =
        itemView.findViewById(R.id.Book_image)

    init {
        itemView.setOnClickListener { onItemClicked(itemView) }
    }

    private val authorsNames: List<String> = arrayListOf<String>("Пушкин А.С.", "Островский А.Н",
        "Гончаров И.А.", "Тургенев И.С.", "Достоевский Ф.М.")

    private val booksNames: List<String> = arrayListOf<String>(
        "Зимнее утро", "Узник", "Евгений Онегин", "Медный всадник",
        "Гроза", "Бесприданница", "Снегурочка", "Свои люди - сочтёмся",
        "Обломов", "Обрыв", "Необыкновенная история", "Обыкновенная",
        "Отцы и дети", "Муму", "Записки охотника", "Первая любовь",
        "Преступление и наказание", "Белые ночи", "Бедные люди", "Идиот")

    private val booksYears: List<String> = arrayListOf<String>(
        "1829", "1822", "1833", "1833",
        "1859", "1878", "1873", "1849",
        "1847", "1869", "1824", "1844",
        "1860", "1852", "1852", "1860",
        "1865", "1848", "1844", "1867",)

    fun bind(item: Book) {
        nameView.text = booksNames[adapterPosition]
        authorView.text = "Автор: " + authorsNames[adapterPosition/4]
        yearView.text = "Год создания: " + booksYears[adapterPosition]
        ratingView.text = "Рейтинг: " + (6..10).random().toString() + "/10"
    }
}
