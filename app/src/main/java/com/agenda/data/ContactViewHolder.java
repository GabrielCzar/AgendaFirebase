package com.agenda.data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.agenda.R;
import com.agenda.models.Contact;

public class ContactViewHolder extends RecyclerView.ViewHolder{
    public TextView nameView;
    public TextView emailView;
    public TextView phoneView;


    public ContactViewHolder(View itemView) {
        super(itemView);

        nameView = itemView.findViewById(R.id.contact_name);
        emailView = itemView.findViewById(R.id.contact_email);
        phoneView = itemView.findViewById(R.id.contact_phone);
    }

    public void bindItem(Contact contact) {
        nameView.setText(contact.name);
        emailView.setText(contact.email);
        phoneView.setText(contact.phone);
    }

}
