package com.example.comp2003restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "restaurant.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_USERS = "users";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email TEXT, " +
                "username TEXT, " +
                "password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // This part is for, upon success, it will add a new user
    public boolean addUser(String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("username", username);
        values.put("password", password);
        long result = db.insert(TABLE_USERS, null, values);
        db.close();
        return result != -1; // Once finished, it will return true if it succeds
    }

    // this part is for, upon success, to check if a user exists (for logging in)
    public boolean checkUser(String usernameOrEmail, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE (username=? OR email=?) AND password=?";
        Cursor cursor = db.rawQuery(query, new String[]{usernameOrEmail, usernameOrEmail, password});

        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }
}


