package com.agenda.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agenda.R;
import com.agenda.models.Contact;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ContactListAdapter extends FirebaseRecyclerAdapter<Contact, ContactViewHolder>{
    private Context context;

    public ContactListAdapter(Context context, FirebaseRecyclerOptions opts) {
        super(opts);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(ContactViewHolder holder, int position, final Contact contact) {
        //final DatabaseReference contactRef = getRef(position);

        holder.itemView.setOnClickListener(view ->
            Toast.makeText(context, contact.name, Toast.LENGTH_LONG).show()
        );
        System.out.println(contact);
        holder.bindItem(contact);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ContactViewHolder(inflater.inflate(R.layout.item_contact, parent, false));
    }
}
