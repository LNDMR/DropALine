package com.example.dropaline.data

import com.example.dropaline.R
import com.example.dropaline.data.model.Contact

class Repository {
    fun loadChats(): List<Contact> {
        return listOf(
            Contact(
                1,
                "Andrew Globerman",
                R.drawable.andrew,
                mutableListOf("Hey, nice to hear from you. What's new?", "yeah, I already knew that..", "I don't want to talk no more, sorry. See you later."),
                mutableListOf()
            ),
            Contact(
                2,
                "Nick Birch",
                R.drawable.nick,
                mutableListOf("Is it urgent?", "yeah, ok", "What should I do about it?"),
                mutableListOf()
            )
        )
    }
}