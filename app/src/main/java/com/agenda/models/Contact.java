package com.agenda.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Contact {
    public String uid;
    public String name;
    public String email;
    public String phone;

    public Contact() {}

    public Contact(String uid, String name, String email, String phone) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name + " " + this.email + " " + this.phone;
    }
}
