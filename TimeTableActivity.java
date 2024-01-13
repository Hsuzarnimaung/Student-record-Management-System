package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Time;

import java.util.List;

/**
 * Created by UCSM on 10/26/2016.
 */

public class TimeTableActivity extends AppCompatActivity {
    Spinner timeclass;
   Spinner year;
    Spinner major;
    Spinner section;
    Spinner day;
    EditText time1;
    EditText time2;
    EditText time3;
    EditText time4;
    EditText time5;
    EditText time6;
    EditText time7;
    String firsttime;
    String secondtime;
    String thirdtime;
    String fourthtime;
    String fifthtime;
    String sixthtime;
    String seventhtime;
    EditText timeDay;
    String dayOne;
    Button btnSave;
    String timeYear;
    String class1;
    String timemajor;
    String timesection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.input_time_table);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Insert Data");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        day=(Spinner) findViewById(R.id.spinnerDay);
        time1=(EditText)findViewById(R.id.time1);
        time2=(EditText)findViewById(R.id.time2);
        time3=(EditText)findViewById(R.id.time3);
        time4=(EditText)findViewById(R.id.time4);
        time5=(EditText)findViewById(R.id.time5);
        time6=(EditText)findViewById(R.id.time6);
        time7=(EditText)findViewById(R.id.time7);
        timeDay=(EditText)findViewById(R.id.day1);
        year=(Spinner) findViewById(R.id.spinnerYear);
        timeclass=(Spinner) findViewById(R.id.spinnerClass);
        major=(Spinner) findViewById(R.id.spinnerMajor);
        btnSave=(Button)findViewById(R.id.SaveButton);
        section=(Spinner) findViewById(R.id.spinnerSection);




        timesection=section.getSelectedItem().toString();

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeYear=year.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        major.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timemajor=major.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                class1=timeclass.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dayOne=day.getSelectedItem().toString();
                timeDay.setText(dayOne);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firsttime=time1.getText().toString();
                secondtime=time2.getText().toString();
                thirdtime=time3.getText().toString();
                fourthtime=time4.getText().toString();
                fifthtime=time5.getText().toString();
                sixthtime=time6.getText().toString();
                seventhtime=time7.getText().toString();


                DatabaseHandler db=new DatabaseHandler(getBaseContext());
                    Time time=new Time(timeYear,class1
                            ,timemajor,timesection,dayOne,
                            firsttime,secondtime,
                            thirdtime,fourthtime,
                            fifthtime,sixthtime,seventhtime);
                    db.insertTime(time);

                   List<Time> list= db.getAllTimeData();

                    for(Time time8:list){
                        Log.i(" Time Output : ",time8.getAcademicyear()+"&&"+time8.getTimeclass()+"&&"+time8.getTimemajor()+"&&"+time8.getTimeselect()+"&&"+time8.getTimeday()+"&&"+time8.getTime1()+"&&"+time8.getTime2()+"&&"+time8.getTime3()+"&&"+time8.getTime4());
                    }
                    finish();
                Intent intent=new Intent(getApplicationContext(),SelectTimeTableActivity.class);
                    startActivity(intent);
                }



        });

    }
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
