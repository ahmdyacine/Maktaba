package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book

/**
 * Repository for managing book data
 * This follows the Repository pattern to abstract data sources
 */
class BookRepository {

    /**
     * TODO for Students (TP1 - Exercise 1):
     * Complete the book information for each book in the list below.
     * Add the following information for each book:
     * - isbn: Use a valid ISBN-13 format (e.g., "978-3-16-148410-0")
     * - nbPages: Add the actual number of pages
     *
     * Example:
     * Book(
     *     isbn = "978-0-13-468599-1",
     *     title = "Clean Code",
     *     nbPages = 464
     * )
     */
    //adding the missing informatuion for each book
    private val booksList = listOf(
        Book(isbn = "9780132350884", title = "Clean Code", nbPages = 464),
        Book(isbn = "9780201616224", title = "The Pragmatic Programmer: From Journeyman to Master", nbPages = 321),
        Book(isbn = "9780201633610", title = "Design Patterns", nbPages = 416),
        Book(isbn = "9780201485677", title = "Refactoring: Improving the Design of Existing Code", nbPages = 431),
        Book(isbn = "9780596007126", title = "Head First Design Patterns", nbPages = 638),
        //adding new books
        Book(isbn = "9780262032933", title = "Introduction to Algorithms", nbPages = 1184),
        Book(isbn = "9780201657883", title = "Programming Pearls", nbPages = 239),
        Book(isbn = "9780131103627", title = "The C Programming Language", nbPages = 272),
        Book(isbn = "9780201558029", title = "Concrete Mathematics: A Foundation for Computer Science", nbPages = 672),
        Book(isbn = "9781105979125", title = "Operating Systems: Three Easy Pieces", nbPages = 686)
    )

    /**
     * TODO for Students (TP1 - Exercise 2):
     * Add 5 more books to the list above.
     * Choose books related to Computer Science, Programming, or any topic you like.
     * Remember to include complete information (ISBN, title, nbPages).
     *
     * Tip: You can find ISBN numbers for books on:
     * - Google Books
     * - Amazon
     * - GoodReads
     */

    /**
     * Get all books from the repository
     * @return List of all books
     */
    fun getAllBooks(): List<Book> {
        return booksList
    }

    /**
     * Get a book by ISBN
     * @param isbn The ISBN of the book to find
     * @return The book if found, null otherwise
     */
    fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
}
