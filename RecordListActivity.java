package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.ucsm.studentrecordmanagement.adapter.StudentViewLayout;
import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by UCSM on 10/26/2016.
 */

public class RecordListActivity extends AppCompatActivity {

    StudentViewLayout studentViewLayout;
    ListView recordList;

    List<Student> dataList;

    DatabaseHandler db;
    Cursor recordCursor;

    Toolbar listToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_list_main);

       listToolbar = (Toolbar) findViewById(R.id.recodToobar);

        listToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        recordList = (ListView) findViewById(R.id.lstRecord);
        studentViewLayout = new StudentViewLayout(this, R.layout.record_list_view);

        recordList.setAdapter(studentViewLayout);

        dataList = getDataList();

        for(Student data : dataList){
            studentViewLayout.add(data);
        }

        recordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item =dataList.get(position).getStudentId()+"|"+dataList.get(position).getStudentName()+"|"+dataList.get(position).getStudentRollNo()+"|"+dataList.get(position).getStudentGender()
                        +"|"+dataList.get(position).getStudentDob()+"|"+dataList.get(position).getStudentFather()+"|"+dataList.get(position).getStudentClass()+"|"+dataList.get(position).getStudentMajor()
                        +"|"+dataList.get(position).getStudentSection()+"|"+dataList.get(position).getStudentAcademic()+"|"+dataList.get(position).getStudentPhoneno()+"|"
                        +dataList.get(position).getStudentEmail()+"|"+dataList.get(position).getStudentAddress();
                Intent intent = new Intent(RecordListActivity.this, RecordDetailActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }

        });
    }
    public List<Student> getDataList(){
        List<Student> datalist = new ArrayList<Student>();

        db = new DatabaseHandler(this);
        recordCursor = db.getAllStudentData();


        if (recordCursor.moveToFirst()) {
            do {
                Student data = new Student();
                data.setStudentId(recordCursor.getString(1));
                data.setStudentName(recordCursor.getString(2));
                data.setStudentRollNo(recordCursor.getString(3));
                data.setStudentGender(recordCursor.getString(4));
                data.setStudentDob(recordCursor.getString(5));
                data.setStudentFather(recordCursor.getString(6));
                data.setStudentClass(recordCursor.getString(7));
                data.setStudentMajor(recordCursor.getString(8));
                data.setStudentSection(recordCursor.getString(9));
                data.setStudentAcademic(recordCursor.getString(10));
                data.setStudentPhoneno(recordCursor.getString(11));
                data.setStudentEmail(recordCursor.getString(12));
                data.setStudentAddress(recordCursor.getString(13));

                datalist.add(data);
            }while (recordCursor.moveToNext());
        }
        return datalist;

    }
}
