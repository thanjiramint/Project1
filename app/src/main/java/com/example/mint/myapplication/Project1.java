package com.example.mint.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Project1 extends ActionBarActivity {

    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        helper = new DBHelper(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
/***
        // This method is called when this activity is put foreground.
        helper = new CourseDBHelper(this.getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues r = new ContentValues();
        r.put("code", code);
        r.put("credit", credit);
        r.put("grade", grade);
        r.put("value", gradeToValue(grade));
        long new_id = db.insert("course", null, r);

***/

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM summary;", null);
        cursor.moveToFirst(); // get the first row

if (cursor.getCount() > 0) {

    int TTC = cursor.getInt(0); // get the first column
    int TtN = cursor.getInt(1);

    Log.d("summary", "TotalCourse is " + TTC + "");
    Log.d("summary", "TotalNote is " + TtN + "");

    TextView tv = (TextView) findViewById(R.id.tts);
    TextView tv1 = (TextView) findViewById(R.id.ttc);


    tv.setText(Integer.toString(TTC));
    tv1.setText(Integer.toString(TtN));
}

    }

    public void buttonClicked(View v) {
        int id = v.getId();
        Intent i;

        switch(id) {
            case R.id.course_add:
                i = new Intent(this, AddCourse.class);
               startActivityForResult(i,88);
                break;

            case R.id.course_list:
                i = new Intent(this, ListCourse.class);
                startActivity(i);
                break;

            case R.id.timetable:
                i = new Intent(this, schedule.class);
                startActivity(i);

                break;

            case R.id.reset:

                SQLiteDatabase db = helper.getWritableDatabase();
                int n_rows = db.delete("course","", null);
                int n_rows2 = db.delete("summary","", null);
                onResume();

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
                String code = data.getStringExtra("code");
                int credit = data.getIntExtra("credit", 0);
                String diff = data.getStringExtra("diff");
                String date1 = data.getStringExtra("date1");
                String date2 = data.getStringExtra("date2");
                String time1 = data.getStringExtra("time1");
                String time2 = data.getStringExtra("time2");

                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues r = new ContentValues();
                r.put("code", code);
                r.put("credit", credit);
                r.put("date1", date1);
                r.put("date2", date2);
                r.put("time1", time1);
                r.put("time2", time2);
                r.put("diff", diff);
                long new_id = db.insert("course", null, r);

                Log.d("course", new_id + "");
            }
        }

        Log.d("course", "onActivityResult");
    }

}
