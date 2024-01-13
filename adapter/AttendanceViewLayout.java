package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


import com.example.ucsm.studentrecordmanagement.R;

import java.util.ArrayList;

/**
 * Created by UCSM on 10/24/2016.
 */

public class AttendanceViewLayout extends CursorAdapter{
   public static int pre=0;
   public static int absent=0;
   public static ArrayList absentName;
    public static ArrayList presentName;
    public AttendanceViewLayout(Context context, Cursor c) {
        super(context, c);
    }

    @Override

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.activity_list_view,parent,false);
        return view;
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView name = (TextView) view.findViewById(R.id.txtName);
        TextView roll = (TextView) view.findViewById(R.id.txtRollNo);
        TextView section = (TextView) view.findViewById(R.id.txtSection);
        final Switch attendance=(Switch) view.findViewById(R.id.toggle);
        final String name1 = cursor.getString(3);
        String roll1= cursor.getString(2);
        String section1 = cursor.getString(9);
        name.setText("Name    : "+name1+"");
        roll.setText("Roll        : "+roll1+"");
        section.setText("Section : "+section1+"");
        absentName=new ArrayList();
        presentName=new ArrayList();
        if(cursor.moveToFirst()){
            do{
                if(attendance.isChecked()){

                }else {
                    absentName.add(cursor.getString(3));

                }
            }while (cursor.moveToNext());
            absent++;
        }


        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(attendance.isChecked()){
                    if(!(name1.equals(""))) {
                           presentName.add(name1);
                        pre++;
                        for (int i = 0; i < absentName.size(); i++) {
                            if (absentName.get(i) == name1)
                                absentName.remove(i);
                        }
                     absent--;
                    }
                }else {
                    for(int i=0;i<presentName.size();i++){
                        if(presentName.get(i)==name1) {
                            presentName.remove(i);
                        }
                    }
                    pre--;

                    if(!name1.equals("")) {
                        absentName.add(name1);
                        absent++;
                    }
                }

            }
        });
}


}
