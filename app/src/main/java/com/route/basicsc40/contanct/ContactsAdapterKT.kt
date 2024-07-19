package com.route.basicsc40.contanct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.basicsc40.R
import com.route.basicsc40.model.ContactDMKt

class ContactsAdapterKT(
    var contacts: ArrayList<ContactDMKt>,
    var onClick: (contact: ContactDMKt, index: Int) -> Unit
) : Adapter<ContactsAdapterKT.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contactDM = contacts[position]
        holder.profileImageView.setImageResource(contactDM.image)
        holder.nameTextView.text = contactDM.name
        holder.phoneNumberTextView.text = contactDM.phoneNumber

        holder.itemView.setOnClickListener {
            onClick.invoke(contactDM, position)
        }
    }

    override fun getItemCount(): Int = contacts.size

    var onItemClick: OnItemClick? = null

    fun interface OnItemClick {
        fun onClick(contact: ContactDMKt, index: Int)
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {

        val profileImageView: ImageView = itemView.findViewById(R.id.item_contact_image)
        val nameTextView: TextView = itemView.findViewById(R.id.item_contact_name)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.item_contact_phonenumber)
    }


}