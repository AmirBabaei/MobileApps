package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.widget.Toast;

public class DBhandler extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context ctx;
    static String DB_NAME = "DATABASE";
    static String TABLE_NAME = "NAME_TABLE";
    static int VERSION = 1;

    public DBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        ctx = context;
        VERSION = version;
        DB_NAME = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY, KEY_NAME STRING, KEY_IMAGE BLOB);");
        Toast.makeText(ctx, "TABLE IS CREATED", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(VERSION == oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
            VERSION = newVersion;
            onCreate(db);
            Toast.makeText(ctx, "TABLE IS UPGRADED", Toast.LENGTH_LONG).show();
        }

    }



    public void insert(String titleName, byte[] image){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("KEY_NAME", titleName);
        cv.put("KEY_IMAGE", image);
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }


    public void update(String s, byte[] s1) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FIRST_NAME", s);
        cv.put("LAST_NAME", s1);
        db.execSQL("UPDATE " + TABLE_NAME + " SET KEY_NAME = \"" + s + "\", KEY_IMAGE= \"" + s1 + "\" WHERE KEY_NAME = \"" + s + "\" OR KEY_IMAGE = \"" + s1 + "\";");

    }


    public void delete(String id, String title) {
        db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE _id = \"" + id + "\" OR KEY_NAME = \"" + title + "\";");

    }

    public imageObject[] view(){
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT *  FROM " + TABLE_NAME+";", null);
        imageObject[] items = new imageObject[c.getCount()];
        String[] item_names = new String[c.getCount()];
        String[] item_des = new String[c.getCount()];
        byte[] barr;
        int i= 0;
        while(c.moveToNext()){
            item_names[i]= c.getString(c.getColumnIndex("KEY_NAME"));
            barr = c.getBlob(c.getColumnIndex("KEY_IMAGE"));
            imageObject item = new imageObject(item_names[i],barr);
            items[i] = item;
            i++;
        }
        c.close();
        db.close();
        return items;
    }

}
