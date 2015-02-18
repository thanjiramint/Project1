package com.example.mint.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Mint on 17/2/2558.
 */
public class schedule  extends ActionBarActivity {
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT course,date1,date2,time1,time2 FROM course;", null);

        for(int i=0;cursor.isLast();i++) {
            cursor.moveToPosition(i);
            String course = cursor.getString(0); // get the first column
            String date1 = cursor.getString(1);
            String date2 = cursor.getString(2);
            String time1 = cursor.getString(3);
            String time2 = cursor.getString(4);

            if (date1.contentEquals("Mon")) {
                if(time1.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.mon1);
                    tv.setText(course);
                }
                else if(time1.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.mon2);
                    tv.setText(course);
                }
                else if(time1.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.mon3);
                    tv.setText(course);
                }
                else if(time1.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.mon4);
                    tv.setText(course);
                }
            }
            if (date1.contentEquals("Tue")) {
                if(time1.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.tue1);
                    tv.setText(course);
                }
                else if(time1.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.tue2);
                    tv.setText(course);
                }
                else if(time1.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.tue3);
                    tv.setText(course);
                }
                else if(time1.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.tue4);
                    tv.setText(course);
                }
            }
            if (date1.contentEquals("Wed")) {
                if(time1.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.wed1);
                    tv.setText(course);
                }
                else if(time1.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.wed2);
                    tv.setText(course);
                }
                else if(time1.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.wed3);
                    tv.setText(course);
                }
                else if(time1.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.wed4);
                    tv.setText(course);
                }
            }
            if (date1.contentEquals("Thurs")) {
                if(time1.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.thurs1);
                    tv.setText(course);
                }
                else if(time1.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.thurs2);
                    tv.setText(course);
                }
                else if(time1.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.thurs3);
                    tv.setText(course);
                }
                else if(time1.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.thurs4);
                    tv.setText(course);
                }
            }
            if (date1.contentEquals("Fri")) {
                if(time1.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.fri1);
                    tv.setText(course);
                }
                else if(time1.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.fri2);
                    tv.setText(course);
                }
                else if(time1.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.fri3);
                    tv.setText(course);
                }
                else if(time1.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.mon4);
                    tv.setText(course);
                }
            }
            if (date1.contentEquals("Sat")) {
                if(time1.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.sat1);
                    tv.setText(course);
                }
                else if(time1.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.sat2);
                    tv.setText(course);
                }
                else if(time1.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.sat3);
                    tv.setText(course);
                }
                else if(time1.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.sat4);
                    tv.setText(course);
                }
            }
            //date2 time2
            if (date2.contentEquals("Mon")) {
                if(time2.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.mon1);
                    tv.setText(course);
                }
                else if(time2.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.mon2);
                    tv.setText(course);
                }
                else if(time2.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.mon3);
                    tv.setText(course);
                }
                else if(time2.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.mon4);
                    tv.setText(course);
                }
            }
            if (date2.contentEquals("Tue")) {
                if(time2.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.tue1);
                    tv.setText(course);
                }
                else if(time2.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.tue2);
                    tv.setText(course);
                }
                else if(time2.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.tue3);
                    tv.setText(course);
                }
                else if(time2.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.tue4);
                    tv.setText(course);
                }
            }
            if (date2.contentEquals("Wed")) {
                if(time2.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.wed1);
                    tv.setText(course);
                }
                else if(time2.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.wed2);
                    tv.setText(course);
                }
                else if(time2.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.wed3);
                    tv.setText(course);
                }
                else if(time2.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.wed4);
                    tv.setText(course);
                }
            }
            if (date2.contentEquals("Thurs")) {
                if(time2.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.thurs1);
                    tv.setText(course);
                }
                else if(time2.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.thurs2);
                    tv.setText(course);
                }
                else if(time2.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.thurs3);
                    tv.setText(course);
                }
                else if(time2.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.thurs4);
                    tv.setText(course);
                }
            }
            if (date2.contentEquals("Fri")) {
                if(time2.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.fri1);
                    tv.setText(course);
                }
                else if(time2.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.fri2);
                    tv.setText(course);
                }
                else if(time2.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.fri3);
                    tv.setText(course);
                }
                else if(time2.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.mon4);
                    tv.setText(course);
                }
            }
            if (date2.contentEquals("Sat")) {
                if(time2.contentEquals("9.00-10.20")) {
                    TextView tv = (TextView) findViewById(R.id.sat1);
                    tv.setText(course);
                }
                else if(time2.contentEquals("10.20-12.00")) {
                    TextView tv = (TextView) findViewById(R.id.sat2);
                    tv.setText(course);
                }
                else if(time2.contentEquals("13.00-14.20")) {
                    TextView tv = (TextView) findViewById(R.id.sat3);
                    tv.setText(course);
                }
                else if(time2.contentEquals("14.40-16.00")) {
                    TextView tv = (TextView) findViewById(R.id.sat4);
                    tv.setText(course);
                }
            }

        }
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