package com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.agenda.data.ContactListAdapter;
import com.agenda.data.ContactViewHolder;
import com.agenda.models.Contact;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Contact, ContactViewHolder> mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_contacts);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        layoutManager = new LinearLayoutManager(this);

        Query contactsQuery = getQuery(mDatabase);

        FirebaseRecyclerOptions opts = new FirebaseRecyclerOptions.Builder<Contact>()
                .setQuery(contactsQuery, Contact.class)
                .build();

        mAdapter = new ContactListAdapter(this, opts);

        mAdapter.notifyDataSetChanged();
    }

    public Query getQuery(DatabaseReference databaseReference) {
        return databaseReference.child("contacts");
    }
}
