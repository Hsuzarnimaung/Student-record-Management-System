package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.R;
import com.example.ucsm.studentrecordmanagement.model.ShortCut;

import java.util.List;

/**
 * Created by nclwin on 10/30/16.
 */

    public class ShortcutAdapter extends ArrayAdapter<ShortCut> {

    public ShortcutAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }


    @Override
    public ShortCut getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(ShortCut item) {
        return super.getPosition(item);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.shortcutkey_layout,null);
        }

        ShortCut ShortCutData=(ShortCut)getItem(position);
        TextView year=(TextView)convertView.findViewById(R.id.shortcutkey);
        year.setText(ShortCutData.getShortcutKey());


        return convertView;
    }
}
