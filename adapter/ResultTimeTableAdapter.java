package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.R;
import com.example.ucsm.studentrecordmanagement.model.Time;

import java.util.List;

/**
 * Created by UCSM on 10/26/2016.
 */

public class ResultTimeTableAdapter extends ArrayAdapter<Time> {
    public ResultTimeTableAdapter(Context context, int resource, List<Time> objects) {
        super(context, resource, objects);
    }

    @Nullable
    @Override
    public Time getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.list_view_time_table,null);
        }
        Time time=(Time)getItem(position);
        TextView resultDay=(TextView)convertView.findViewById(R.id.result_day);
        TextView resultTime1=(TextView)convertView.findViewById(R.id.result_sub1);
        TextView resultTime2=(TextView)convertView.findViewById(R.id.result_sub2);
        TextView resultTime3=(TextView)convertView.findViewById(R.id.result_sub3);
        TextView resultTime4=(TextView)convertView.findViewById(R.id.result_sub4);
        TextView resultTime5=(TextView)convertView.findViewById(R.id.result_sub5);
        TextView resultTime6=(TextView)convertView.findViewById(R.id.result_sub6);
        TextView resultTime7=(TextView)convertView.findViewById(R.id.result_sub7);
        resultDay.setText(time.getTimeday());
        resultTime1.setText(time.getTime1());
        resultTime2.setText(time.getTime2());
        resultTime3.setText(time.getTime3());
        resultTime4.setText(time.getTime4());
        resultTime5.setText(time.getTime5());
        resultTime6.setText(time.getTime6());
        resultTime7.setText(time.getTime7());
        return convertView;
    }
}
