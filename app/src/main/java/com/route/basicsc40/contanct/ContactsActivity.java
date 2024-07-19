package com.route.basicsc40.contanct;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.route.basicsc40.R;
import com.route.basicsc40.model.ContactDM;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    ArrayList<ContactDM> contacts = new ArrayList<>();
    RecyclerView recyclerView;
    ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        recyclerView = findViewById(R.id.contactsRV);
        mockContact();
        contactsAdapter = new ContactsAdapter(this, contacts);
        // contactsAdapter.onClickListener =
        recyclerView.setAdapter(contactsAdapter);
//        contactsAdapter.onClickListener = (item, index) -> Toast.makeText(this, "New item clicked " + index, Toast.LENGTH_LONG).show();
    }

    public void mockContact() {
        for (int i = 0; i < 100; i++) {
            contacts.add(new ContactDM(R.drawable.car, "Test name " + i, "01111111" + i));
        }
    }
}