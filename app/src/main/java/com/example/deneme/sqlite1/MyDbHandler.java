package com.example.deneme.sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by deneme on 14.12.2017.
 */

public class MyDbHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="productDB.db";
    private  static final String  TABLE_PRODUCTS="products";
    private  static final String  COLUMN_ID="id";
    private  static final String  COLUMN_PRODUCTSNAME="productname";

    public ArrayList<String> results =new ArrayList<>();

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory ,int version)
    {
        super(context, DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+ TABLE_PRODUCTS +"("+
                COLUMN_ID+"INTEGER PRIMARY KEY AUTOINCREAMENT" +
                COLUMN_PRODUCTSNAME + "TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addGlass(){
        ContentValues values=new ContentValues();
        String text="You drink 1 glass";
        values.put(COLUMN_PRODUCTSNAME,text);
        SQLiteDatabase db =getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }

    public void addBottle(){
        ContentValues values=new ContentValues();
        String text="You drink 1 bottle";
        values.put(COLUMN_PRODUCTSNAME,text);
        SQLiteDatabase db =getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }
    //database den bir şey silmek istersek bunu kullanırız.
    public void deleteProduct(String productName){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM" + TABLE_PRODUCTS + "WHERE" + COLUMN_PRODUCTSNAME + "=\"" + productName + "\";");
    }

    public ArrayList<String> databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_PRODUCTS + "WHERE 1";

        Cursor c =db.rawQuery(query,null);
        c.moveToFirst();

        //
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("productname")) !=null){
                dbString +=c.getString(c.getColumnIndex("productname"));
                dbString+="\n";

                String name=c.getString(c.getColumnIndex("productname"));

                Calendar time=Calendar.getInstance();
                SimpleDateFormat df=new SimpleDateFormat("dd-MMM-YYY-HH:mm");
                String formatteDate=df.format(time.getTime());


                results.add(formatteDate +"    "+"");
            }
            c.moveToNext();
        }
       db.close();
        return results;
    }

}
