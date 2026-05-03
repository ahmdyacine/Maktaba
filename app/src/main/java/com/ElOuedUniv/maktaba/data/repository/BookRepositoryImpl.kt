package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor() : BookRepository {

    private val _booksList = mutableListOf(
        Book(
            isbn = "11111",
            title = "Clean Code",
            nbPages = 464,
            imageUrl = "https://m.media-amazon.com/images/I/41xShlnTZTL.jpg"
        ),
        Book(
            isbn = "22222",
            title = "The Pragmatic Programmer",
            nbPages = 352,
            imageUrl = "https://m.media-amazon.com/images/I/41as+4pfBML.jpg"
        ),
        Book(
            isbn = "33333",
            title = "Design Patterns",
            nbPages = 395,
            imageUrl = "https://m.media-amazon.com/images/I/81gtKoapHFL.jpg"
        ),
        Book(
            isbn = "44444",
            title = "Refactoring",
            nbPages = 448,
            imageUrl = "https://m.media-amazon.com/images/I/4119BEm699L.jpg"
        ),
        Book(
            isbn = "55555",
            title = "Head First Design Patterns",
            nbPages = 672,
            imageUrl = "https://m.media-amazon.com/images/I/81A-mv9N8pL.jpg"
        )

    )

    private val booksFlow = MutableSharedFlow<List<Book>>(replay = 1).apply {
        tryEmit(_booksList.toList())
    }
    
    override fun getAllBooks(): Flow<List<Book>> = flow {
        delay(2000) // Simulate delay
        emitAll(booksFlow)
    }

    override fun getBookByIsbn(isbn: String): Book? {
        return _booksList.find { it.isbn == isbn }
    }

    override fun addBook(book: Book) {
        _booksList.add(book)
        booksFlow.tryEmit(_booksList.toList())
    }
}
