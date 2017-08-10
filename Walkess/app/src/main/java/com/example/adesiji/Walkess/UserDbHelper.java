package com.example.adesiji.Walkess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adesiji on 27/11/2015.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    // create name for the database and the version
    private static final  String DATABASE_NAME ="USERINFO.DB";
    private static final int DATABASE_VERSION = 1;

    // define the query for creating the table
    private static final String CREATE_QUERY =
            // always make sure the space is available after the create table
            "CREATE TABLE " + UserContact.NewUserInfo.TABLE_NAME +
                    "("+ UserContact.NewUserInfo.USER_NAME + " TEXT, " +
                    UserContact.NewUserInfo.USER_ADDRESS + " TEXT , " +
                    UserContact.NewUserInfo.USER_EMAIL  + " TEXT, " +
                    UserContact.NewUserInfo.USER_MOB  + " TEXT , " +
                    UserContact.NewUserInfo.USER_STAFF  + " TEXT , " +
                    UserContact.NewUserInfo.USER_DATE  + " TEXT , " +
                    UserContact.NewUserInfo.USER_TIME + " TEXT , " +
                    UserContact.NewUserInfo.USER_APPOINTMENT  + " TEXT , " +
                    UserContact.NewUserInfo.USER_ID  + " TEXT); ";

    // create a constructor
    public UserDbHelper(Context context)
    {
        // passing 4 argument
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // displace the Log message and the database operation
        Log.e("DATABASE OPERATION", "Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create the query and create the table
    db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION", "Table created ...");

    }

    // create the information for your database
    public void addContact(String name, String address, String mob, String email, String staff, String date, String time,String appointment, String id, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME, name);
        contentValues.put(UserContact.NewUserInfo.USER_ADDRESS, address);
        contentValues.put(UserContact.NewUserInfo.USER_MOB,mob);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,email);
        contentValues.put(UserContact.NewUserInfo.USER_STAFF,staff);
        contentValues.put(UserContact.NewUserInfo.USER_DATE, date);
        contentValues.put(UserContact.NewUserInfo.USER_TIME, time);
        contentValues.put(UserContact.NewUserInfo.USER_APPOINTMENT,appointment);
        contentValues.put(UserContact.NewUserInfo.USER_ID, id);
        // this method allow us to put the value into the database and specify the table name
        db.insert(UserContact.NewUserInfo.TABLE_NAME, null, contentValues);
        // display Log message if there is no exceptions
        Log.e("DATABASE OPERATION", "One row is inserted ...");


    }
// We need to use cursor to get the information from the database
    public Cursor getContact(SQLiteDatabase db)
    {
        // create an message for the method
        Cursor cursor;
        // create the string array
        String[] projections = {
                UserContact.NewUserInfo.USER_NAME,
                UserContact.NewUserInfo.USER_ADDRESS,
                UserContact.NewUserInfo.USER_MOB,
                UserContact.NewUserInfo.USER_EMAIL,
                UserContact.NewUserInfo.USER_STAFF,
                UserContact.NewUserInfo.USER_DATE,
                UserContact.NewUserInfo.USER_TIME,
                UserContact.NewUserInfo.USER_APPOINTMENT,
                UserContact.NewUserInfo.USER_ID,
                };
        // use the sqlite to call the method query, through the argument
        // We need to pass some questions of argument as shown below
        // Get the table name - this is needed
        // Get the Projections - this is needed
        // Do the selections ,
        // Obtain the Selection args
        // Get the group rows
        // Filter by row group
        // Sort orders
        // passing 5 null values
        cursor = db.query(UserContact.NewUserInfo.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                null,
                null);
        return cursor;

     }
    //************close the database


    public Cursor getContact( String user_name, SQLiteDatabase sqLiteDatabase)
    {
        String[]projections = {
                UserContact.NewUserInfo.USER_NAME,
                UserContact.NewUserInfo.USER_ADDRESS,
                UserContact.NewUserInfo.USER_MOB,
                UserContact.NewUserInfo.USER_EMAIL,
                UserContact.NewUserInfo.USER_STAFF,
                UserContact.NewUserInfo.USER_DATE,
                UserContact.NewUserInfo.USER_TIME,
                UserContact.NewUserInfo.USER_APPOINTMENT,
                UserContact.NewUserInfo.USER_ID,
        };
        String selection = UserContact.NewUserInfo.USER_NAME +" LIKE ?";
        String []selection_args = {user_name};
        sqLiteDatabase.query(UserContact.NewUserInfo.TABLE_NAME, projections, selection, selection_args, null, null, null, null);
        Cursor cursor = sqLiteDatabase.query(UserContact.NewUserInfo.TABLE_NAME, projections, selection, selection_args, null, null, null, null);
        return cursor;

    }
    public void deleteContact(String user_name, SQLiteDatabase sqLiteDatabase)
    {
        String selection = UserContact.NewUserInfo.USER_NAME +" LIKE ?";
        // specify the argument
        String[] selection_args = {user_name};
        sqLiteDatabase.delete(UserContact.NewUserInfo.TABLE_NAME, selection, selection_args);

    }

    public int updateContact(String old_name, String new_name, String new_address, String new_mobile, String new_email, String new_staff, String new_date, String new_time, String new_appointment, String new_id, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME, new_name);
        contentValues.put(UserContact.NewUserInfo.USER_ADDRESS, new_address);
        contentValues.put(UserContact.NewUserInfo.USER_MOB, new_mobile);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL, new_email);
        contentValues.put(UserContact.NewUserInfo.USER_STAFF, new_staff);
        contentValues.put(UserContact.NewUserInfo.USER_DATE, new_date);
        contentValues.put(UserContact.NewUserInfo.USER_TIME, new_time);
        contentValues.put(UserContact.NewUserInfo.USER_APPOINTMENT, new_appointment);
        contentValues.put(UserContact.NewUserInfo.USER_ID, new_id);

        String selection = UserContact.NewUserInfo.USER_NAME + " LIKE ?";
        String selection_args = (old_name);
        int count = sqLiteDatabase.update(UserContact.NewUserInfo.TABLE_NAME, contentValues, selection, new String[]{selection_args});
        return count;


    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
