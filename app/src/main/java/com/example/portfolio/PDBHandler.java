package com.example.portfolio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PDBHandler extends SQLiteOpenHelper{

    // database name and version
    private static final int DB_VER = 3;
    private static final String DB_NAME = "pName4.db";

    // table
    private static final String TABLE_PORT = "Portfolios";

    // columns
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PASS = "pass";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_LINK = "LinkedIn";
    private static final String COLUMN_URL = "URL";

    // constructor (unused variables are necessary do not remove!!)
    PDBHandler(Context context, String name,
               SQLiteDatabase.CursorFactory factory, int version)
    {         super(context, DB_NAME, factory, DB_VER);     }

    // This method creates the User table when the DB is initialized.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PORT_TABLE = "CREATE TABLE " +
                TABLE_PORT + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," +
                COLUMN_PASS + " TEXT," +
                COLUMN_PHONE + " INTEGER," +
                COLUMN_ADDRESS + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_LINK + " TEXT," +
                COLUMN_URL + " TEXT" + ")";

        db.execSQL(CREATE_PORT_TABLE);     }

    // This method closes an open DB if a new one is created.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PORT);
        onCreate(db);
    }

    // This method is used to add a User record to the database.
    void addUser(Portfolio user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PASS, user.getPass());
        values.put(COLUMN_PHONE, user.getPhone());
        values.put(COLUMN_ADDRESS, user.getAddress());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_LINK, user.getLink());
        values.put(COLUMN_URL, user.getUrl());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PORT, null, values);
        db.close();
    }


    // implements the search/find functionality
    Portfolio searchUser(String userName) {
        String query = "SELECT * FROM " +
                TABLE_PORT + " WHERE " + COLUMN_NAME +
                " = \"" + userName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Portfolio user = new Portfolio();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            user.setID(Integer.parseInt(cursor.getString(0)));
            user.setName(cursor.getString(1));
            user.setPass(cursor.getString(2));
            user.setPhone(cursor.getString(3));
            user.setAddress(cursor.getString(4));
            user.setEmail(cursor.getString(5));
            user.setLink(cursor.getString(6));
            user.setUrl(cursor.getString(7));
            cursor.close();

        } else {
            user = null;
        }

        db.close();
        return user;
    }

    // implements the delete User functionality
    boolean deleteUser(String userName) {
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_PORT +
                " WHERE " + COLUMN_NAME + " = \"" + userName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Portfolio profile = new Portfolio();

        if (cursor.moveToFirst()) {
            profile.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PORT, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(profile.getID())});

            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}