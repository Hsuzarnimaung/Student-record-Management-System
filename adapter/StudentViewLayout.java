package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.R;
import com.example.ucsm.studentrecordmanagement.RecordListActivity;
import com.example.ucsm.studentrecordmanagement.model.Student;


import java.util.List;

/**
 * Created by UCSM on 10/26/2016.
 */

public class StudentViewLayout extends ArrayAdapter<Student> {
    public StudentViewLayout(Context context, int resource, List<Student> objects) {
        super(context, resource,objects);
    }

    public StudentViewLayout(RecordListActivity showInfo, int show_list_item) {
        super(showInfo,show_list_item);
    }

    public void add(Student object){super.add(object);}

    @Override
    public Student getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.record_list_view,null);

        }
        Student student=(Student) getItem(position);
        TextView name=(TextView)convertView.findViewById(R.id.listname);
        TextView year=(TextView)convertView.findViewById(R.id.listyear);
        name.setText(""+student.getStudentName()+"");
        year.setText(""+student.getStudentClass()+"");
        return convertView;
    }
}
