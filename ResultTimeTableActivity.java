package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.adapter.ResultTimeTableAdapter;
import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Time;

import java.util.List;

/**
 * Created by UCSM on 10/26/2016.
 */

public class ResultTimeTableActivity extends AppCompatActivity {


    ListView listView;
    TextView academicyear;
    TextView resultClass;
    TextView resultMajor;
    TextView resultSection;
    String  resultyear="All";
    String resultclass="All";
    String resultmajor="All";
    String resultselection="All";
    String  resultday="All";
    List<Time> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table_list);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Result");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        listView=(ListView)findViewById(R.id.list);
        academicyear=(TextView)findViewById(R.id.listacademic);
        resultClass=(TextView)findViewById(R.id.listclass);
        resultMajor=(TextView)findViewById(R.id.listmajor);
        resultSection=(TextView)findViewById(R.id.listsection);

        Intent intent=getIntent();
        resultyear=intent.getStringExtra("resultyear");
        resultclass=intent.getStringExtra("resultclass");
        resultmajor=intent.getStringExtra("resultmajor");
        resultselection=intent.getStringExtra("resultselection");
        resultday=intent.getStringExtra("resultday");
        if(resultyear==null&& resultclass==null && resultmajor==null && resultselection==null && resultday==null) {
            academicyear.setText("All");
            resultClass.setText("All");
            resultMajor.setText("All");
            resultSection.setText("All");
            Time time = new Time("All", "All", "All", "All", "All");
            DatabaseHandler db = new DatabaseHandler(getBaseContext());
            list = db.selectTimeTable(time);
            for (Time time1 : list) {
                Log.i("Select Item Output : ", time1.getAcademicyear() + "&&"
                        + time1.getTimeclass() + "&&" + time1.getTimemajor()
                        + time1.getTimeselect() + "&&" + time1.getTimeday() + "&&"
                        + time1.getTime1() + "&&" + time1.getTime2()
                        + time1.getTime3() + "&&" + time1.getTime4());
            }
        }else {

            academicyear.setText(resultyear);
            resultClass.setText(resultclass);
            resultMajor.setText(resultmajor);
            resultSection.setText(resultselection);
            Time time = new Time(resultyear, resultclass, resultmajor, resultselection, resultday);
            DatabaseHandler db = new DatabaseHandler(getBaseContext());
            list = db.selectTimeTable(time);
            for (Time time1 : list) {
                Log.i("Select Item Output : ", time1.getAcademicyear() + "&&"
                        + time1.getTimeclass() + "&&" + time1.getTimemajor()
                        + time1.getTimeselect() + "&&" + time1.getTimeday() + "&&"
                        + time1.getTime1() + "&&" + time1.getTime2()
                        + time1.getTime3() + "&&" + time1.getTime4());
            }

        }
       ResultTimeTableAdapter result=new ResultTimeTableAdapter(getBaseContext(),R.layout.list_view_time_table,list);
        listView.setAdapter(result);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.timetablemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        switch (item.getItemId()){

            case R.id.addtimetable:

                Intent intent=new Intent(getApplicationContext(),TimeTableActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.selecttable:

                Intent intent1=new Intent(getApplicationContext(),SelectTimeTableActivity.class);
                startActivity(intent1);
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
