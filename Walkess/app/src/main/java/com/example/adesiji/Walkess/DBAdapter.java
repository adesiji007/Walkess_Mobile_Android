package com.example.adesiji.Walkess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adesiji on 31/12/2015.
 */
public class DBAdapter {
    static  final String KEY_ROWID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_ADDRESS = "address";
    static final String KEY_MOBILE= "mobile";
    static final String KEY_EMAIL= "email";
    static final String KEY_STAFF= "staff";
    static final String KEY_DATE = "date";
    static final String KEY_TIME = "time";
    static final String KEY_APPOINTMENT = "appointment";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "name";
    static final String DATABASE_TABLE = "name";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_CREATE =
            "create table contact (_id integer primary key autoincrement, " + "name text to null, address text to null, " +
                    " mobile text to null,email text to null, staff text to null, date text to null, time text to null, appointment text to null );";
    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter (Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try{
                db.execSQL(DATABASE_CREATE);
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);

        }
    }

    // -------------------opens the database -------------

    public DBAdapter open()throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //-----------------close the database-----------
    public void close()
    {
        DBHelper.close();
    }


    //------------------insert a contact into the database----------------

    public long insertContact(String name, String address, String mobile, String email, String staff, String date, String time, String appointment)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_ADDRESS, address);
        initialValues.put(KEY_MOBILE, mobile);
        initialValues.put(KEY_EMAIL, email);
        initialValues.put(KEY_STAFF, staff);
        initialValues.put(KEY_DATE, date);
        initialValues.put(KEY_TIME, time);
        initialValues.put(KEY_APPOINTMENT, appointment);
        return db.insert(DATABASE_TABLE, null,initialValues);

    }

    // --------------deletes a particular contact---------------
    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE,KEY_ROWID + " = " + rowId, null)> 0;

    }

    //---------------retrieves all the contacts---------------------

    private Cursor getAllContacts()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME, KEY_ADDRESS, KEY_MOBILE},null, null,null,null,null,null);
    }

    //----------------retrieves a particular contact-------------------------
    public Cursor getContact(long rowId)throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID, KEY_NAME, KEY_ADDRESS, KEY_MOBILE,
                                KEY_EMAIL, KEY_STAFF, KEY_DATE, KEY_TIME, KEY_APPOINTMENT}, KEY_ROWID + "=" + rowId,
                        null,null,null,null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //-----------------updates a contact---------------------------
    public boolean updateContact(long rowId, String name, String address, String mobile, String email, String staff, String date, String time, String appointment )
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_ADDRESS, address);
        args.put(KEY_MOBILE, mobile);
        args.put(KEY_EMAIL, email);
        args.put(KEY_STAFF, staff);
        args.put(KEY_DATE, date);
        args.put(KEY_TIME, time);
        args.put(KEY_APPOINTMENT, appointment);
        return db.update(DATABASE_TABLE,args, KEY_ROWID +"=" + rowId, null)> 0;

    }
}
