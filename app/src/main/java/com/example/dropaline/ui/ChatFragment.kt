package com.example.dropaline.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.dropaline.MainViewModel
import com.example.dropaline.adapter.ContactAdapter
import com.example.dropaline.adapter.MessageAdapter
import com.example.dropaline.data.model.Message
import com.example.dropaline.databinding.FragmentChatBinding

class ChatFragment: Fragment() {

    private lateinit var binding: FragmentChatBinding

    // shared viewModel
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val messageAdapter = MessageAdapter()
        binding.chatRecycler.adapter = messageAdapter

        // Argument von nav
        val currentContactIdx = requireArguments().getInt("position")

        viewModel.createChat(currentContactIdx)

        binding.chatContactNameText.text = viewModel.contactList.value!![currentContactIdx].name

        viewModel.chat.observe(viewLifecycleOwner) {
            Log.d("HomeFragment", "contactList live data received")
            messageAdapter.submitList(it)
        }

        // content of chat_input_editText view is assigned to contact.chat
        binding.chatSendButton.setOnClickListener {
            val content = binding.chatImputEditText.text.toString()
            if(content != "") {
                viewModel.sendText(content)
                binding.chatImputEditText.setText("")
            }
        }
    }

}