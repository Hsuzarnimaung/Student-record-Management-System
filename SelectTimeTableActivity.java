package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by UCSM on 10/26/2016.
 */

public class SelectTimeTableActivity extends AppCompatActivity {

    Spinner academicyear;
    Spinner selectclass;
    Spinner selectmajor;
    Spinner selectsection;
    Spinner selectday;
    Button btnOk;
    Button btnCancel;

    String resultyear;
    String resultclass;
    String resultmajor;
    String resultselection;
    String resultday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table_form);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Time Table");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));
        academicyear=(Spinner)findViewById(R.id.selectYear);
        selectclass=(Spinner)findViewById(R.id.selectClass);
        selectmajor=(Spinner)findViewById(R.id.selectMajor);
        selectsection=(Spinner)findViewById(R.id.selectSection);
        selectday=(Spinner)findViewById(R.id.selectDay);
        btnOk=(Button)findViewById(R.id.btnOk);
        btnCancel=(Button)findViewById(R.id.btnCancel);







        academicyear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultyear=academicyear.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       selectclass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               resultclass=selectclass.getSelectedItem().toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


        selectmajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultmajor=selectmajor.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        selectsection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultselection=selectsection.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        selectday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultday=selectday.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),ResultTimeTableActivity.class);
                intent.putExtra("resultyear",resultyear);
                intent.putExtra("resultclass",resultclass);
                intent.putExtra("resultmajor",resultmajor);
                intent.putExtra("resultselection",resultselection);
                intent.putExtra("resultday",resultday);
                startActivity(intent);
                finish();

            }
        });

     }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(getApplicationContext(),ResultTimeTableActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
