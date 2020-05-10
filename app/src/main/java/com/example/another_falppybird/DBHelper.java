package com.example.another_falppybird;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableLayout;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBName = "gamedata.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "score";
    private static final String ID = "_id";
    private static final String SCORE = "score";
    private SQLiteDatabase myDB;

    public DBHelper (Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getID() {
        return ID;
    }

    public static String getSCORE() {
        return SCORE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE "+ TABLE_NAME + "( " + ID + " INTEGER DEFAULT 1 PRIMARY KEY AUTOINCREMENT, " +
                SCORE + " INTEGER DEFAULT 1  NOT NULL " + ") ";
        db.execSQL(queryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }
    }

    public void openDB() {
        myDB = getWritableDatabase();
    }

    public void closeDB()
    {
        if (myDB!= null && myDB.isOpen())
        {
            myDB.close();
        }
    }

    public Cursor getHighScore()
    {
        String query = "SELECT MAX(score) AS score FROM " + TABLE_NAME;
        return myDB.rawQuery(query, null);
    }

    public long Insert(int score){
        ContentValues values = new ContentValues();
        values.put(SCORE, score);
        return myDB.insert(TABLE_NAME,null,values);
    }

    public Cursor getAll()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        return myDB.rawQuery(query, null);
    }

}
