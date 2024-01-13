package com.example.ucsm.studentrecordmanagement;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ucsm.studentrecordmanagement.adapter.AttendanceViewLayout;
import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Record;
import com.example.ucsm.studentrecordmanagement.model.Student;

import java.util.Calendar;
import java.util.List;



/**
 * Created by UCSM on 10/24/2016.
 */

public class ClassAttendanceActivity extends AppCompatActivity {

    private AttendanceViewLayout lstViewActivity;
    private ListView lstView;
    Button show ,reset,recordview;
    int id1=0;

    String totalAbsentName="";
    String totalPresentName="";
    Toolbar attendanceToolbar;

   TextView txtDate ;

   DatabaseHandler databaseHandler;



    Cursor attendanceCursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

        attendanceToolbar = (Toolbar) findViewById(R.id.toolbar);

        attendanceToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtDate = (TextView) findViewById(R.id.txtdate);

        reset = (Button) findViewById(R.id.btnReset);
        recordview = (Button) findViewById(R.id.view);

        recordview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AttendanceRecordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        databaseHandler = new DatabaseHandler(this);

        attendanceCursor = databaseHandler.getAllStudentData();



        lstView = (ListView) findViewById(R.id.listview);
        lstViewActivity = new AttendanceViewLayout(this,attendanceCursor);
        lstView.setAdapter(lstViewActivity);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstViewActivity.pre=0;
                lstViewActivity.absent=0;
                totalAbsentName="";
                totalPresentName="";
                lstViewActivity.presentName=null;
                lstViewActivity.absentName=null;


            }
        });

        show = (Button) findViewById(R.id.showSummary);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( (txtDate.length() == 0 && (lstViewActivity.pre == 0 && lstViewActivity.absent == 0) )|| (txtDate.length()==0 || (lstViewActivity.pre ==0 && lstViewActivity.absent==0)) ) {
                    Toast.makeText(getBaseContext(), "Do something !!", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ClassAttendanceActivity.this);
                    builder.setTitle("Information!!");
                    builder.setMessage("Date  :  " + txtDate.getText().toString() + "\nTotal number of Present : " + lstViewActivity.pre + "\n" + "Total number of Absent  : " + lstViewActivity.absent);
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:

                                    for(int i=0;i<lstViewActivity.presentName.size();i++){
                                        totalPresentName+=lstViewActivity.presentName.get(i)+"\n";
                                    }
                                    for(int i=0;i<lstViewActivity.absentName.size();i++){
                                        totalAbsentName+=lstViewActivity.absentName.get(i)+"\n";
                                        Log.i("absent name",totalAbsentName);
                                    }
                                    databaseHandler.insertRecordData(new Record(txtDate.getText().toString(),lstViewActivity.pre,
                                            lstViewActivity.absent,attendanceCursor.getCount(),totalPresentName,totalAbsentName));
                                    lstViewActivity.pre=0;
                                    lstViewActivity.absent=0;
                                    totalAbsentName="";
                                    totalPresentName="";
                                    lstViewActivity.presentName=null;
                                    lstViewActivity.absentName=null;
                                    Log.i("Output :",txtDate.getText().toString()+"&&"+lstViewActivity.pre+"&&"+lstViewActivity.absent+"&&"+attendanceCursor.getCount());
                                    Intent intent = new Intent(ClassAttendanceActivity.this, AttendanceRecordActivity.class);
                                    startActivity(intent);
                                    finish();
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    builder.setPositiveButton("Ok", dialogClickListener);
                    builder.setNegativeButton("No", dialogClickListener);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }

    public void onClickDate(View view){
        final Calendar c;
        c = Calendar.getInstance();
        final int myear = c.get(Calendar.YEAR);
        final int mmouth = c.get(Calendar.MONTH);
        final int mday = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dpd;
        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {


            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

            }
        }, myear, mmouth, mday);
        dpd.show();
    }


}
