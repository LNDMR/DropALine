package com.example.dropaline.data.model

data class Contact(
    // TODO: ? do I need the id
    val id: Int,
    val name: String,
    val imageResource: Int,
    // TODO: autoResponse needs to be implemented in ChatFragment (.kt & .xml)
    val autoResponse: MutableList<Message>,
    val chat: MutableList<Message>
)
