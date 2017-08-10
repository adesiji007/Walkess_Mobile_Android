package com.example.adesiji.Walkess;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by adesiji on 02/12/2015.
 */
public class SearchContactActivity extends AppCompatActivity {

    TextView display_address, display_email,display_mobile, display_date, display_time,display_id ;
    TextView New_Search, New_Name, New_Address, New_Email,New_Mobile, New_Date, New_Time,New_ID ;
    EditText Search_name;
    Button UpdateButton;
    EditText title_text;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name, SearchName;
   // String search_id;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_contact_layout);
        Search_name = (EditText)findViewById(R.id.search_name);
        Search_name.getText().toString();
        New_Search = (EditText)findViewById(R.id.search_name);

        New_Name = (TextView)findViewById(R.id.display_Address);
        New_Address = (TextView)findViewById(R.id.display_Address);
        New_Email = (TextView)findViewById(R.id.display_Email);
        New_Mobile = (TextView)findViewById(R.id.display_Mobile);
        New_Date = (TextView)findViewById(R.id.display_Date);
        New_Time = (TextView)findViewById(R.id.display_Time);
        New_ID = (TextView)findViewById(R.id.display_ID);

        New_Name.setVisibility(View.GONE);
        New_Address.setVisibility(View.GONE);
        New_Email.setVisibility(View.GONE);
        New_Mobile.setVisibility(View.GONE);
        New_Date.setVisibility(View.GONE);
        New_Time.setVisibility(View.GONE);
        New_ID.setVisibility(View.GONE);




    }

    public void searchContact(View view)
    {
        this.view = view;
        search_name = Search_name.getText().toString();
        // initialioze userdbhelper
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor = userDbHelper.getContact( search_name, sqLiteDatabase);
        if(cursor.moveToFirst())
        {

            String Address = cursor.getString(0);
            String Mobile = cursor.getString(1);
            String Email = cursor.getString(2);
            String Date = cursor.getString(3);
            String Time = cursor.getString(4);
            String Id = cursor.getString(5);

            display_address.setText(Address);
            display_email.setText(Email);
            display_mobile.setText(Mobile);
            display_date.setText(Date);
            display_time.setText(Time);
            display_id.setText(Id);

            display_address.setVisibility(View.VISIBLE);
            display_email.setVisibility(View.VISIBLE);
            display_mobile.setVisibility(View.VISIBLE);
            display_date.setVisibility(View.VISIBLE);
            display_time.setVisibility(View.VISIBLE);
            display_id.setVisibility(View.VISIBLE);





            String NewName = cursor.getString(0);
            NewName = cursor.getString(1);
            String NewAddress = cursor.getString(2);
            String NewMobile = cursor.getString(3);
            String NewEmail = cursor.getString(4);
            String NewDate = cursor.getString(5);
            String NewTime = cursor.getString(6);
            String NewID = cursor.getString(7);
            NewName = SearchName;
            Toast.makeText(getBaseContext(),"Contact searching.........", Toast.LENGTH_LONG).show();


        }
    }


    public  void deleteContact(View view)
    {
        // initialioze user dbhelper
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.deleteContact(search_name, sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact deleted", Toast.LENGTH_LONG).show();

    }
    public void BackToContact(View view)
    {
        int id = view.getId();
        if (id == R.id.btnBack) {
            Intent intent = new Intent(view.getContext(), Booking.class);
            startActivity(intent);
        }
    }
}
