package com.example.rafaelle.airportlinknomap;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

/**
 * Created by Carrot on 21-Oct-15.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String TAG = "rafaelle";//for debugging purposes

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "itinerary.db";
    public static final String TABLE_ITINERARY = "itinerary";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_START = "start";
    public static final String COLUMN_END = "end";
    public static final String COLUMN_DURATION = "duration";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ITINERARY + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_START + " TEXT " +
                COLUMN_END + " TEXT " +
                COLUMN_DURATION + " INTEGER " +
                ");";
        db.execSQL(query);
        Log.i(TAG, "query: " + query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITINERARY);
        onCreate(db);
    }

    public void addItinerary(itinerary i){
        ContentValues values = new ContentValues();
        values.put(COLUMN_START, i.get_start());
        values.put(COLUMN_END, i.get_duration());
        values.put(COLUMN_DURATION, i.get_duration());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITINERARY, null, values);
        db.close();
    }

    public String readStart(){
        String start = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITINERARY + " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("start"))!=null){
                start = cursor.getString(cursor.getColumnIndex("start"));
            }
        }
        db.close();
        return start;
    }

    public String readEnd(){
        String end = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITINERARY + " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("end"))!=null){
                end = cursor.getString(cursor.getColumnIndex("end"));
            }
        }
        db.close();
        return end;
    }
    public int readDuration(){
        int duration = 0;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITINERARY + " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("duration"))!=null){
                duration = cursor.getInt(cursor.getColumnIndex("duration"));
            }
        }
        db.close();
        return duration;
    }
}
