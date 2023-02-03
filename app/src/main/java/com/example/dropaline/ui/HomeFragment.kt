package com.example.dropaline.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.dropaline.MainViewModel
import com.example.dropaline.adapter.ContactAdapter
import com.example.dropaline.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding

    // wenn mehrere Fragmente sich ein ViewModel teilen
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // create new ContactAdapter()
        // link the Adapter to the recyclerView (HF)
        val contactAdapter = ContactAdapter()
        binding.contactsRecycler.adapter = contactAdapter


        // HomeFragment observed die contactList der ModelView ?
        viewModel.contactList.observe(viewLifecycleOwner, Observer{
            Log.d("HomeFragment", "contactList live data received")
            contactAdapter.submitList(it)
        })

    }

}