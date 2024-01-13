package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ucsm.studentrecordmanagement.adapter.AttendaceRecordLayout;
import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;


/**
 * Created by UCSM on 10/28/2016.
 */

public class AttendanceRecordActivity extends AppCompatActivity {

    AttendaceRecordLayout recordLayout;
    ListView lstAtRecord;
    Cursor cursorRecord;

    DatabaseHandler handler;
    Toolbar toolbar ;

    //@Override
    public void onBackPressed() {
        finish();
        Intent intent=new Intent(AttendanceRecordActivity.this,ClassAttendanceActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_detail_main);

        toolbar = (Toolbar) findViewById(R.id.attenToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AttendanceRecordActivity.this,ClassAttendanceActivity.class);
                startActivity(intent);
                finish();
            }
        });

        handler = new DatabaseHandler(this);
        cursorRecord = handler.getAllData();
        lstAtRecord = (ListView) findViewById(R.id.lstAttendance);
        recordLayout= new AttendaceRecordLayout(this,cursorRecord);

        lstAtRecord.setAdapter(recordLayout);


        lstAtRecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              cursorRecord=handler.getRecordData((int)id);
                Log.i("id",String.valueOf(id));
                cursorRecord.moveToFirst();
                Intent intent = new Intent(AttendanceRecordActivity.this,AttendanceRecordDetailActivity.class);
                intent.putExtra("date",cursorRecord.getString(1));
                intent.putExtra("totalpresent",cursorRecord.getInt(2));
                intent.putExtra("totalabsent",cursorRecord.getInt(3));
                intent.putExtra("totalstudent",cursorRecord.getInt(4));
                intent.putExtra("presentlist",cursorRecord.getString(5));
                intent.putExtra("absentlist",cursorRecord.getString(6));
                startActivity(intent);
                cursorRecord.close();
            }
        });

    }

}
