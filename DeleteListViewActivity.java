package com.example.ucsm.studentrecordmanagement;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;


import com.example.ucsm.studentrecordmanagement.adapter.DeleteListAdapter;
import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;

import java.util.ArrayList;

/**
 * Created by thaeoonge on 10/28/2016.
 */

public class DeleteListViewActivity extends AppCompatActivity {
    ArrayList list = new ArrayList();
    CheckBox cbx;
    int data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final DatabaseHandler dbhandler = new DatabaseHandler(this);


        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Delete Information");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        final ListView listView = (ListView) findViewById(R.id.list_data);

        DeleteListAdapter adapter = new DeleteListAdapter(DeleteListViewActivity.this, dbhandler.getAllStudentData());

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cbx = (CheckBox) view.findViewById(R.id.checkbox);


                //Toast.makeText(DeleteListViewActivity.this, "Action Enter", Toast.LENGTH_SHORT).show();
                if (cbx.isChecked()) {
                    cbx.setChecked(false);
                    data = (int) id;
                    for(int i=0;i<list.size();i++){
                        if((int)list.get(i)==data){
                            list.remove(i);
                        }
                    }
                    Log.i(list+""," res of data");
                } else {
                    cbx.setChecked(true);
                    data = (int) id;
                    list.add(data);
                    Log.i(list+""," res of data");
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
           /* default:
               return super.onOptionsItemSelected(item);*/
        }

        switch (item.getItemId()) {

            case R.id.deleteData:
                deleteItem();

                return true;
            case R.id.cancelData:
                finish();
                Intent i=new Intent(getApplicationContext(),RecordActivity.class);
                startActivity(i);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }


    public void deleteItem() {
        if(list.size()!=0) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(DeleteListViewActivity.this);
            dialog.setTitle("Delete");
            dialog.setMessage("Sure you want to delete record?");

            dialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    for (int j = 0; j < list.size(); j++) {
                        DatabaseHandler db = new DatabaseHandler(DeleteListViewActivity.this);
                        db.deleteStudentData((Integer) list.get(j));
                    }

                    new RecordActivity().killRecord();
                    Intent i = new Intent(getApplicationContext(), RecordActivity.class);
                    startActivity(i);
                    finish();


                }
            });


            dialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }else {
            Toast.makeText(this, "You havenot selected Data", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), RecordActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}
