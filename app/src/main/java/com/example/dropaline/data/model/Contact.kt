package com.example.dropaline.data.model

data class Contact(
    val id: Int,
    val name: String,
    val imageResoource: Int,
    val autoResponse: MutableList<String>,
    val chat: MutableList<String>
)
