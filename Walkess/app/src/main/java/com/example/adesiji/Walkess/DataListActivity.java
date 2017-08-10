package com.example.adesiji.Walkess;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;//for the sqlitedatabase
    UserDbHelper userDbHelper;//for getting the information from database
    Cursor cursor;
    ListDataAdapter listDataAdapter;//declare the object of listdataAdaptor


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
// get the information from the database and initialise dbHelper
        listView = (ListView)findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        // To get the data or information from the database
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        //sqLiteDatabase = userDbHelper.getWritableDatabase();
        // getting information from database and create an object of cursor
        cursor = userDbHelper.getContact(sqLiteDatabase);
// analyse the cursor object to check the information either is true or false
        if(cursor.moveToFirst()) {
            // get each information from the cursor object
            do {
                String name,address, mob, email, date, time, id;
                name = cursor.getString(0);
                address = cursor.getString(1);
                mob = cursor.getString(2);
                email = cursor.getString(3);
                date = cursor.getString(4);
                time = cursor.getString(5);
                id = cursor.getString(6);
                // create an object of dataprovider
                DataProvider dataProvider = new DataProvider(name, address, mob, email, date, time, id);
                listDataAdapter.add(dataProvider);


            }
            while (cursor.moveToNext()) ;

        }

    }

}
