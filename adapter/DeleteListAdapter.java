package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.R;


/**
 * Created by thaeoonge on 10/28/2016.
 */

public class DeleteListAdapter extends CursorAdapter {

    public DeleteListAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_delete, null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView listName = (TextView) view.findViewById(R.id.listname2);
        TextView listYear = (TextView) view.findViewById(R.id.listyear2);
        final CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkbox);

        listName.setText(cursor.getString(3));
        listYear.setText(cursor.getString(7));
    }


}
