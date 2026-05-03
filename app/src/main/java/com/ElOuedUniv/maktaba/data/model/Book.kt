package com.ElOuedUniv.maktaba.data.model

data class Book(
    val isbn: String,
    val title: String,
    val nbPages: Int,
    val imageUrl: String?,
    val status: String = "Reading",
    val progress: Int = 0
)

