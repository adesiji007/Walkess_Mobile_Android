package com.example.adesiji.Walkess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by adesiji on 27/11/2015.
 */
public class
        Booking extends AppCompatActivity {




    ImageButton buttonAddContact = null;
    ImageButton buttonViewContacts = null;
    ImageButton buttonSearchContact = null;
    ImageButton buttonUpdateContact = null;
    ImageButton buttonDeleteContact = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_main);

        buttonAddContact = (ImageButton) findViewById(R.id.buttonAddContact);
        //buttonAddContact.setOnClickListener(this);
        buttonViewContacts = (ImageButton) findViewById(R.id.buttonViewContact);
        //buttonViewContacts.setOnClickListener(this);
        buttonSearchContact = (ImageButton) findViewById(R.id.buttonSearchContact);
        //buttonSearchContact.setOnClickListener(this);
        buttonUpdateContact = (ImageButton) findViewById(R.id.buttonUpdateContact);
        //buttonUpdateContact.setOnClickListener(this);
        buttonDeleteContact = (ImageButton) findViewById(R.id.buttonDeleteContact);
        //buttonDeleteContact.setOnClickListener(this);
    }
    public void addClick (View view) {
        int id = view.getId();
        if (id == R.id.buttonAddContact) {
            Intent intent = new Intent(view.getContext(), AddContact.class);
            startActivity(intent);
        }
    }

    public void viewContact (View view)
    {
        int id = view.getId();
        if (id == R.id.buttonViewContact)
        {
            Intent intent = new Intent(view.getContext(), DataListActivity.class);
            startActivity(intent);
        }
    }

    public void deleteContact (View view)
    {
        int id = view.getId();
        if (id == R.id.buttonDeleteContact)
        {
            Intent intent = new Intent(view.getContext(), DeleteContactActivity.class);
            startActivity(intent);
        }
    }
    public void updateContact (View view)
    {
        int id = view.getId();
        if (id == R.id.buttonUpdateContact)
        {
            Intent intent = new Intent(view.getContext(), DeleteContactActivity.class);
            startActivity(intent);
        }
    }
    public void searchClick(View view) {
        int id = view.getId();

        if (id == R.id.buttonSearchContact) {
            Intent intent = new Intent(view.getContext(), SearchContactActivity.class);
            startActivity(intent);
        }
    }
    public void onClickbuttonBack(View view) {
        int id = view.getId();

        if (id == R.id.buttonBack) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        }
    }
    public void storageClick(View view)
    {
        int id = view.getId();
        if (id == R.id.storageContact) {
            Intent intent = new Intent(view.getContext(), InternalStorage.class);
            startActivity(intent);
        }
    }
    public void databaseContact(View view)
    {
        int id = view.getId();
        if (id == R.id.deleteDatabase) {
            Intent intent = new Intent(view.getContext(), DeleteContactActivity.class);
            startActivity(intent);
        }
    }

}



