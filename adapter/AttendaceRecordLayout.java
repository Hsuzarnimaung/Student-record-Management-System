package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.R;


/**
 * Created by UCSM on 10/28/2016.
 */

public class AttendaceRecordLayout extends CursorAdapter {
    public AttendaceRecordLayout(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.record_detail,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView date=(TextView)view.findViewById(R.id.date);
        date.setText(cursor.getString(1));

    }


}
