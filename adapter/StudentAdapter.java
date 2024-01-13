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
 * Created by UCSM on 10/24/2016.
 */

public class StudentAdapter extends CursorAdapter {
    public StudentAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.detail_main_list,null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView listName=(TextView)view.findViewById(R.id.listname);
        TextView listYear=(TextView)view.findViewById(R.id.listyear);
        listName.setText(cursor.getString(3));
        listYear.setText(cursor.getString(7));

    }
}
