package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by UCSM on 10/28/2016.
 */

public class AttendanceRecordDetailActivity extends AppCompatActivity {

    TextView tDate,tPreTotal,tAbTotal,tStuTotal,tPreList,tAbList;

    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance_detail_layout);

        toolbar = (Toolbar) findViewById(R.id.detailToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tDate = (TextView) findViewById(R.id.date1);
        tPreTotal = (TextView) findViewById(R.id.totalPresent);
        tAbTotal = (TextView) findViewById(R.id.totalAbsent);
        tStuTotal = (TextView) findViewById(R.id.totalStudent);
        tPreList = (TextView) findViewById(R.id.listPre);
        tAbList = (TextView) findViewById(R.id.listAb);

        Intent intent=getIntent();
        String date=intent.getStringExtra("date");
        int totalpresent=intent.getIntExtra("totalpresent",1);
        int totalabsent=intent.getIntExtra("totalabsent",1);
        int totalstudent=intent.getIntExtra("totalstudent",1);
        String presentlist=intent.getStringExtra("presentlist");
        String absentlist=intent.getStringExtra("absentlist");
        tDate.setText(date);
        tPreTotal.setText(String.valueOf(totalpresent));
        tAbTotal.setText(String.valueOf(totalabsent));
        tStuTotal.setText(String.valueOf(totalstudent));
        tPreList.setText(presentlist);
        tAbList.setText(absentlist);
        Log.i("result output : ",date+"&&"+totalpresent+"&&"+totalabsent+"&&"+totalstudent);

    }
}
