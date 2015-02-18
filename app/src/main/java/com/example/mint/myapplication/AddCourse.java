package com.example.mint.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class AddCourse extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);
    }

    public void addClicked(View v) {
     EditText code = (EditText)findViewById(R.id.code);
     EditText cr = (EditText)findViewById(R.id.credit);
     EditText name = (EditText)findViewById(R.id.name);

     EditText book = (EditText)findViewById(R.id.book);

     EditText date1 = (EditText)findViewById(R.id.date1);
     EditText date2 = (EditText)findViewById(R.id.date2);
     EditText time1 = (EditText)findViewById(R.id.time1);
     EditText time2 = (EditText)findViewById(R.id.time2);

     RadioGroup diff = (RadioGroup)findViewById(R.id.diff);

       String sCode = code.getText().toString();
        String sName = code.getText().toString();
       String sCR = cr.getText().toString();
       String sbook = book.getText().toString();
       String sdate1 = date1.getText().toString();
       String sdate2 = date2.getText().toString();
       String stime1 = time1.getText().toString();
       String stime2 = time2.getText().toString();


        if (sCode.trim().length() == 0 || sCR.trim().length() == 0 ||
                sbook.trim().length() == 0 || sdate1.trim().length() == 0 || sdate2.trim().length() == 0 ||
               stime1.trim().length() == 0 || stime2.trim().length() == 0 ) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "Both course code and credit are necessary.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent();
            result.putExtra("course", sCode);
            result.putExtra("name", sName);
            result.putExtra("credit", Integer.valueOf(sCR));
            result.putExtra("book", sbook);
            result.putExtra("date1", sdate1);
            result.putExtra("date2", sdate2);
            result.putExtra("time1", stime1);
            result.putExtra("time2", stime2);


            int dID = diff.getCheckedRadioButtonId();
            String diffi = ((RadioButton)findViewById(dID)).getText().toString();
            result.putExtra("diff", diffi);
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
