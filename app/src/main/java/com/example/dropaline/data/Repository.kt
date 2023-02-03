package com.example.dropaline.data

import com.example.dropaline.R
import com.example.dropaline.data.model.Contact
import com.example.dropaline.data.model.Message

class Repository {
    fun loadContacts(): List<Contact> {
        return listOf(
            Contact(
                1,
                "Andrew Globerman",
                R.drawable.andrew,
                mutableListOf(Message("Hey, nice to hear from you. What's new?"), Message("yeah, I already knew that.."), Message("I don't want to talk no more, sorry. See you later.")),
                mutableListOf(Message("my last message to Andrew"))
            ),
            Contact(
                2,
                "Nick Birch",
                R.drawable.nick,
                mutableListOf(Message("Is it urgent?"), Message("yeah, ok"), Message("What should I do about it?")),
                mutableListOf(Message("my last message to Nick"))
            )
        )
    }
}