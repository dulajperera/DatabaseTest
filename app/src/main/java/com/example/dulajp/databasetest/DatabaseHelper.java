package com.example.dulajp.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DULAJP on 7/27/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String  DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "SURNAME";
    public static final String COL4 = "MARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //create the database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist "+TABLE_NAME+"");
        onCreate(db);
    }

    //define the table columns
    public boolean insertData(String name, String surname, String marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,surname);
        contentValues.put(COL4,marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return  false;
        else
            return  true;
    }
}
