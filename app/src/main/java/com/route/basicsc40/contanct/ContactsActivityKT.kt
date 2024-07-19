package com.route.basicsc40.contanct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.basicsc40.R
import com.route.basicsc40.model.ContactDMKt

class ContactsActivityKT : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var contacts = ArrayList<ContactDMKt>()
    lateinit var adapter: ContactsAdapterKT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mockContacts()
        recyclerView = findViewById(R.id.contactsRV)
        adapter = ContactsAdapterKT(contacts) { contact, index ->

        };
        recyclerView.adapter = adapter
    }

    private fun mockContacts() {
        for (i: Int in 0..100) {
            contacts.add(
                ContactDMKt(
                    image = R.drawable.car,
                    name = "Test name $i",
                    phoneNumber = "011111$i"
                )
            )
        }
    }
}