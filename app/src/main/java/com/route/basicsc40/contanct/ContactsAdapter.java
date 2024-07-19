package com.route.basicsc40.contanct;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.route.basicsc40.R;
import com.route.basicsc40.model.ContactDM;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {
    ArrayList<ContactDM> contacts;
    OnClickListener onClickListener;

    public ContactsAdapter(ContactsActivity context, ArrayList<ContactDM> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_contact, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        Log.e("onCreateViewHolder", "Created new viewholder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.e("onBindViewHolder", "Binding holder number " + position);
        Log.e("Test", "x");
        ContactDM contactDM = contacts.get(position);
        holder.profileImage.setImageResource(contactDM.getImageId());
        holder.nameTv.setText(contactDM.getName());
        holder.phoneNumberTv.setText(contactDM.getPhoneNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onItemClick(contactDM, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    interface OnClickListener {
        void onItemClick(ContactDM item, int index);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView nameTv;
        TextView phoneNumberTv;

        MyViewHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.item_contact_image);
            nameTv = itemView.findViewById(R.id.item_contact_name);
            phoneNumberTv = itemView.findViewById(R.id.item_contact_phonenumber);
        }
    }
}
