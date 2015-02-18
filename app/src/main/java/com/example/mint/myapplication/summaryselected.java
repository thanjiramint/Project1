package com.example.mint.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mint on 17/2/2558.
 */
public class summaryselected extends ActionBarActivity {
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summaryselect);

        //sqlใส่ไห้ตรงกับที่เราเช็ค??
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *.summary FROM summary,course WHERE course.course=course.summary ;", null);
        cursor.moveToFirst(); // get the first row
        String topic = cursor.getString(2); // get the first column
        String date = cursor.getString(3);
        String note = cursor.getString(4);

        TextView tv = (TextView)findViewById(R.id.topicShow);
        TextView tv1 = (TextView)findViewById(R.id.date_show);
        TextView tv2 = (TextView)findViewById(R.id.note);


        tv.setText(topic);
        tv1.setText(date);
        tv2.setText(note);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}