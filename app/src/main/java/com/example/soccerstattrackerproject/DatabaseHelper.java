package com.example.soccerstattrackerproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "stats.db";
    public static final String TABLE_NAME = "PLAYERS";
    //Columns
    public static final String  COL_1 = "ID";
    public static final String COL_2 = "PLAYERNAME";
    public static final String COL_3 = "MINUTESPLAYED";
    public static final String COL_4 = "POSSITION";
    public static final String COL_5 = "GOALS";
    public static final String COL_6 = "ASSISTS";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PLAYERNAME TEXT,MINUTESPLAYED TEXT, POSSITION  TEXT,  GOALS TEXT ,ASSISTS TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String min, String pos,  String goals, String assists){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,min);
        contentValues.put(COL_4,pos);
        contentValues.put(COL_5,goals);
        contentValues.put(COL_6, assists);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id, String name, String min, String pos,  String goals, String assists){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,min);
        contentValues.put(COL_4,pos);
        contentValues.put(COL_5,goals);
        contentValues.put(COL_6, assists);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[]{ id });
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[] { id });
    }
}
