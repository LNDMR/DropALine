package com.example.dropaline.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dropaline.R
import com.example.dropaline.data.model.Contact
import com.example.dropaline.ui.HomeFragmentDirections

class ContactAdapter(): RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {
    
    // create dataset -> empty list of type contact
    private var contactDataset = listOf<Contact>()

    // inner Class ItemViewHolder -> the View that will be recycled and all the necessary attributes ?
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName: TextView = view.findViewById(R.id.contact_name_text)
        val contactLastLine: TextView = view.findViewById(R.id.contact_line_text)
        val contactImage: ImageView = view.findViewById(R.id.contact_image)
        val contactCard: CardView = view.findViewById(R.id.contact_card)
    }

    // ?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    // ?
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val contact = contactDataset[position]

        holder.contactName.text = contact.name

        if(contact.chat.size > 0) {
            holder.contactLastLine.text = contact.chat[0].messageContent
        }

        holder.contactImage.setImageResource(contact.imageResource)

        holder.contactCard.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToChatFragment(position))
        }
    }

    fun submitList(list: List<Contact>) {
        contactDataset = list
        notifyDataSetChanged()
        Log.d("ContactAdapter", "contactList is submitted")
    }

    override fun getItemCount(): Int {
        return contactDataset.size
    }
    
}