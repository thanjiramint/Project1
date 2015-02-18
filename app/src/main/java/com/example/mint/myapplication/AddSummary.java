package com.example.mint.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by Mint on 17/2/2558.
 */
public class AddSummary extends ActionBarActivity {
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);
    }

    public void addClickedNote(View v) {
        EditText topic = (EditText)findViewById(R.id.topic_n);
        EditText date_add = (EditText)findViewById(R.id.date_add);
        EditText note = (EditText)findViewById(R.id.note);


        String sTopic = topic.getText().toString();
        String sDate = date_add.getText().toString();
        String sNote = note.getText().toString();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id ,course FROM course;", null);
        cursor.moveToFirst(); // get the first row
        String sCourse = cursor.getString(1); // get the first column
        //?? เช็คidให้ตรงกับที่เราจิ้ม ทำยังไง??


        if (sTopic.trim().length() == 0 || sDate.trim().length() == 0 || sNote.trim().length() == 0 ) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "Both course code and credit are necessary.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent();
            result.putExtra("course", sCourse);
            result.putExtra("topic", sTopic);
            result.putExtra("datew", sDate);
            result.putExtra("note", sNote);

            this.setResult(RESULT_OK, result);
            this.finish();
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
