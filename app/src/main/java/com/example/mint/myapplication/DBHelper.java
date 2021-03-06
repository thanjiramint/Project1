package com.example.mint.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String name = "courses.sqlite3";
    private static final int version = 7;


    public DBHelper(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE course (" +
                "_id integer primary key autoincrement," +
                "course text null," +
                "course_name text null," +
                "credit int default 0," +
                "diff text null," +
                "date1 text null," +
                "time1 text null," +
                "date2 text null," +
                "time2 text null);";

        String sql2 = "CREATE TABLE summary (" +
                "_id integer primary key autoincrement," +
                "course text null," +
                "topic text null," +
                "datew text null," +
                "note text null);";
        db.execSQL(sql);
       db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS course;";
        db.execSQL(sql);
        String sql2 = "DROP TABLE IF EXISTS summary;";
        db.execSQL(sql2);

        this.onCreate(db);
    }
}
