package com.example.adesiji.Walkess;

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
 * Created by adesiji on 14/12/2015.
 */
public class DeleteContactActivity extends AppCompatActivity {
//TextView display_address, display_email,display_mobile, display_date, display_time,display_id ;
    TextView New_Search, New_Name, New_Address, New_Email,New_Mobile, New_Date, New_Time,New_ID ;
    EditText Search_name;
    Button UpdateButton;
    EditText title_text;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name, SearchName;
    String search_id;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_contact_activity);
        Search_name = (EditText)findViewById(R.id.search_name);

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
            String NewName = cursor.getString(0);
            NewName = cursor.getString(1);
            String NewAddress = cursor.getString(2);
            String NewMobile = cursor.getString(3);
            String NewEmail = cursor.getString(4);
            String NewDate = cursor.getString(5);
            String NewTime = cursor.getString(6);
            String NewID = cursor.getString(7);
            NewName = SearchName;

            // set the text information

            New_Name.setText(NewName);
            New_Address.setText(NewAddress);
            New_Email.setText(NewEmail);
            New_Mobile.setText(NewMobile);
            New_Date.setText(NewDate);
            New_Time.setText(NewTime);
            New_ID.setText(NewID);

            // set visibility for the view
            New_Name.setVisibility(View.VISIBLE);
            New_Address.setVisibility(View.VISIBLE);
            New_Email.setVisibility(View.VISIBLE);
            New_Mobile.setVisibility(View.VISIBLE);
            New_Date.setVisibility(View.VISIBLE);
            New_Time.setVisibility(View.VISIBLE);
            New_ID.setVisibility(View.VISIBLE);

            UpdateButton.setVisibility(View.VISIBLE);
            title_text.setVisibility(View.VISIBLE);



        }
    }


    public  void deleteContact(View view)
    {
        // initialioze user dbhelper
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.deleteContact(search_name, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Contact deleted", Toast.LENGTH_LONG).show();

    }
}
