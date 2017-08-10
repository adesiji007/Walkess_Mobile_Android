package com.example.adesiji.Walkess;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by adesiji on 27/11/2015.
 */
public class AddContact extends AppCompatActivity {
    EditText ContactID, ContactName, ContactAddress, ContactMobile, ContactEmail, ContactStaff;
    Button ContactDate, ContactTime, ContactAppointment;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_layout);

        ContactName = (EditText) findViewById(R.id.contact_name);
        ContactAddress = (EditText) findViewById(R.id.contact_address);
        ContactMobile = (EditText) findViewById(R.id.contact_mobile);
        ContactEmail = (EditText) findViewById(R.id.contact_email);
        ContactStaff = (EditText) findViewById(R.id.contact_staff);
        ContactID = (EditText) findViewById(R.id.contact_id);

        ContactDate = (Button) findViewById(R.id.ButtonDate);
        ContactTime = (Button)findViewById(R.id.ButtonTime);
        ContactAppointment = (Button)findViewById(R.id.appointmentType);
    }


        public void addContact(View view) {

        String name = ContactName.getText().toString();
        String address = ContactAddress.getText().toString();
        String mob = ContactMobile.getText().toString();
        String email = ContactEmail.getText().toString();
        String date = ContactDate.getText().toString();
        String time = ContactTime.getText().toString();
        String id = ContactName.getText().toString();
            String staff = ContactTime.getText().toString();
            String appointment = ContactTime.getText().toString();

        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        // add information to the database
        userDbHelper.addContact(name, address, mob, email,staff, date, time, id, appointment, sqLiteDatabase);

        // display the toast
        Toast.makeText(getBaseContext(), "Data Saved ", Toast.LENGTH_LONG).show();
            int idd = view.getId();

            if (idd == R.id.saveContact) {
                Intent intent = new Intent(view.getContext(), Booking.class);
                startActivity(intent);
            }

        userDbHelper.close();


    }
    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event)
    {
        switch (KeyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Toast.makeText(getBaseContext(),
                        "Center was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Toast.makeText(getBaseContext(),
                        "Center was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Toast.makeText(getBaseContext(),
                        "Center was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                Toast.makeText(getBaseContext(),
                        "Center was clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Toast.makeText(getBaseContext(),
                        "Center was clicked",
                        Toast.LENGTH_LONG).show();
                break;

        }
        return false;

    }
      public void saveContact(View view) {
        int id = view.getId();

        if (id == R.id.saveContact) {
            Intent intent = new Intent(view.getContext(), Booking.class);
            startActivity(intent);
        }
    }
    public void time(View view)
    {
        int id = view.getId();

        if (id == R.id.ButtonTime) {
            Intent intent = new Intent(view.getContext(), Time.class);
            startActivity(intent);
        }
    }
    public void date(View view)
    {
        int id = view.getId();

        if (id == R.id.ButtonDate) {
            Intent intent = new Intent(view.getContext(), Date.class);
            startActivity(intent);
        }
    }
    public void addBack(View view)
    {
        int id = view.getId();
        if (id == R.id.buttonBack) {
            Intent intent = new Intent(view.getContext(), Booking.class);
            startActivity(intent);
        }
    }
    public void onClickappointmentType(View view)
    {
        int id = view.getId();
        if (id == R.id.appointment_type) {
            Intent intent = new Intent(view.getContext(), AppointmentType.class);
            startActivity(intent);
        }
    }
    public void addAppointment(View view)
    {
        int id = view.getId();
        if (id == R.id.appointment) {
            Intent intent = new Intent(view.getContext(), AppointmentType.class);
            startActivity(intent);
        }
    }
;

}
