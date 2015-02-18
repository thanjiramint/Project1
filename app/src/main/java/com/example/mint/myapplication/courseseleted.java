package com.example.mint.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mint on 17/2/2558.
 */
public class courseseleted extends ActionBarActivity {

        DBHelper helper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.course);

            helper = new DBHelper(this);
        }

        @Override
        protected void onResume() {
            super.onResume();

            // This method is called when this activity is put foreground.

            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT SUM(note) TtN FROM summary DISTINCT;", null);
            cursor.moveToFirst(); // get the first row
            int TtN = cursor.getInt(0); // get the first column

            Cursor cursor2 = db.rawQuery("SELECT date1, date2, time1, time2, book FROM course;", null);
            cursor2.moveToFirst(); // get the first row
            String date1 = cursor2.getString(0);
            String date2 = cursor2.getString(1);
            String time1 = cursor2.getString(2);
            String time2 = cursor2.getString(3);
            String book = cursor2.getString(4);


            Log.d("summary","TotalNote is "+ TtN+"");

            TextView tv = (TextView)findViewById(R.id.tts);
            TextView tv1 = (TextView)findViewById(R.id.dates1);
            TextView tv2 = (TextView)findViewById(R.id.dates2);
            TextView tv3 = (TextView)findViewById(R.id.times1);
            TextView tv4 = (TextView)findViewById(R.id.times2);
            TextView tv5 = (TextView)findViewById(R.id.bookn);

            tv.setText(Integer.toString(TtN));
            tv1.setText(date1);
            tv2.setText(date2);
            tv3.setText(time1);
            tv4.setText(time2);
            tv5.setText(book);

        }

        public void buttonClickedCourse(View v) {
            int id = v.getId();
            Intent i;

            switch(id) {
                case R.id.summarylist:
                    i = new Intent(this, ListSummary.class);
                    startActivityForResult(i,88);
                    break;

                case R.id.addsummary:
                    i = new Intent(this, AddSummary.class);
                    startActivity(i);
                    break;

                case R.id.menu:
                    i = new Intent(this, Project1.class);
                    startActivity(i);

                    break;

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

        /**
         * A placeholder fragment containing a simple view.
         */
        public static class PlaceholderFragment extends Fragment {

            public PlaceholderFragment() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.main, container, false);
                return rootView;
            }
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == 88) {
                if (resultCode == RESULT_OK) {
                    String topic = data.getStringExtra("topic");
                    String datew = data.getStringExtra("datew");
                    String note = data.getStringExtra("note");

                    SQLiteDatabase db = helper.getWritableDatabase();
                    ContentValues r = new ContentValues();
                    r.put("topic", topic);
                    r.put("datew", datew);
                    r.put("note", note);

                    long new_id = db.insert("summary", null, r);

                    Log.d("summary", new_id + "");
                }
            }

            Log.d("summary", "onActivityResult");
        }

    }


