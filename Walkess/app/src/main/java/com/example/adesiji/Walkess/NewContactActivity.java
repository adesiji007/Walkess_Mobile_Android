package com.example.adesiji.Walkess;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by adesiji on 27/11/2015.
 */
public class NewContactActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {
    Toast myToast = null;
    EditText ContactName,ContactAddress, ContactMobile, ContactEmail, ContactStaff, ContactAppointment, ContactId;
    Button ContactDate, ContactTime;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    Button submitButton = null;
    Button buttonSave = null;
    DatePicker dueDatePicker = null;
    Task task = null;
    Button buttonBack = null;
    Button buttonDate = null;
    Button buttonTime = null;


    Date dueDate = null;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.id.add_contact_layout);

        ContactName = (EditText)findViewById(R.id.contact_name);
        ContactAddress = (EditText)findViewById(R.id.contact_address);
        ContactMobile = (EditText)findViewById(R.id.contact_mobile);
        ContactEmail = (EditText)findViewById(R.id.contact_email);
        ContactStaff = (EditText)findViewById(R.id.contact_staff);
        ContactAppointment = (EditText)findViewById(R.id.appointmentType);
        ContactId = (EditText) findViewById(R.id.contact_id);


        buttonBack = (Button)findViewById(R.id.buttonBack);
        //buttonBack.setOnClickListener(this);

        buttonSave = (Button)findViewById(R.id.saveContact);
        //buttonSave.setOnClickListener(this);

        //buttonDate = (Button)findViewById(R.id.contact_date1);
        //buttonDate.setOnClickListener(this);

        //buttonTime = (Button)findViewById(R.id.contact_time1);
        //buttonTime.setOnClickListener(this);



        myToast = new Toast(this.getApplicationContext());
        submitButton = (Button)findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createTask(v);
            }
        });
        dueDate = new Date();

        dueDatePicker = (DatePicker)findViewById(R.id.datePicker);
        // initialise the datePicker
        // Otherwise onDateChange events are not picked up
        dueDatePicker.init(dueDatePicker.getYear(), dueDatePicker.getMonth(),dueDatePicker.getDayOfMonth(),this );

    }

    public void createTask(View v) {
        int id = v.getId();

        if (id == R.id.datePicker){
            Intent intent = new Intent(v.getContext(), Task.class );
            startActivity(intent);
        }

        //Get information from the editTextTaskName
        // taskName = editTextTaskName.getText().toString();
        //taskDescription = editTextTaskDescription.getText().toString();


        //if( taskName.length()>0 & taskDescription.length()>0){
        // Add task
        task = new Task(dueDate);
        // to do - create string resources and move text
            /*myToast.makeText(this.getApplicationContext(), "Task created: Date: " + task.getTaskDate(), Toast.LENGTH_SHORT).show();
        }
        else{

            myToast.makeText(this.getApplicationContext(), "Please Enter All Required Details", Toast.LENGTH_SHORT).show();
        }**/
    }


    public void addContact (View view)
    {
        String name = ContactName.getText().toString();
        String address = ContactAddress.getText().toString();
        String mob = ContactMobile.getText().toString();
        String email = ContactEmail.getText().toString();
        String staff = ContactEmail.getText().toString();
        String date = ContactDate.getText().toString();
        String time = ContactTime.getText().toString();
        String appointment = ContactEmail.getText().toString();
        String id = ContactId.getText().toString();




        UserDbHelper ud  = new UserDbHelper (context);
        ud.getWritableDatabase();
        sqLiteDatabase = ud.getWritableDatabase();
        // add information to the database
        userDbHelper.addContact( name,  address, mob, email, staff, date, time, appointment,id, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved ", Toast.LENGTH_LONG).show();

        userDbHelper.close();

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // Calendar cal = Calendar.getInstance();
        // cal.set(year, monthOfYear, dayOfMonth);
        dueDate.setDate(dayOfMonth);
        dueDate.setYear(year);
        dueDate.setMonth(monthOfYear);
    }
/**
    public void addDate(View view) {
        int id = view.getId();

        if (id == R.id.contact_date1) {
            Intent intent = new Intent(view.getContext(), Date.class);
            startActivity(intent);
        }
    }
    public void addTime(View view) {
        int id = view.getId();

        if (id == R.id.contact_time1) {
            Intent intent = new Intent(view.getContext(), Time.class);
            startActivity(intent);
        }
    }
 **/
    public void addBack(View view) {
        int id = view.getId();

        if (id == R.id.buttonBack) {
            Intent intent = new Intent(view.getContext(), Booking.class);
            startActivity(intent);
        }
    }
    public void saveContact(View view) {
        int id = view.getId();

        if (id == R.id.buttonBack) {
            Intent intent = new Intent(view.getContext(), Booking.class);
            startActivity(intent);
        }
    }
}
