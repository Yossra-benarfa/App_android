package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {

    public DB(Context context) {
        super(context,"App.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username Text primary key,password Text, code Text, is_confirmed Boolean)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String username, String password , String code){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("code",code);
        contentValues.put("is_confirmed", false);
        long result = myDB.insert(  "users", null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery( "select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean checkusernamepassword(String username,String password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery( "select * from users where username = ? and password = ?",new String[] {username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkUserCode(String username,String code)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery( "select * from users where username = ? and code = ?",new String[] {username,code});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public Boolean confirmUser(String username)
    {
        try {
            SQLiteDatabase myDB = this.getWritableDatabase();

            myDB.execSQL("update users set is_confirmed=true where username = ? ", new String[]{username});
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


}

