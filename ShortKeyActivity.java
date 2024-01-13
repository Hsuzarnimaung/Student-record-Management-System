package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.ucsm.studentrecordmanagement.adapter.ShortcutAdapter;
import com.example.ucsm.studentrecordmanagement.model.ShortCut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nclwin on 10/30/16.
 */

public class ShortKeyActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Shortcut Key");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        List<ShortCut> list=new ArrayList<ShortCut>();
        ShortCut[] shortCuts=new ShortCut[]{new ShortCut("BASIC SHORTCUT KEYS")
        ,new ShortCut("MICROSOFT WINDOWS SHORTCUT KEYS"),
        new ShortCut("WINKEY SHORTCUT KEYS"),
        new ShortCut("WORD SHORTCUT KEYS"),
        new ShortCut("EXCEL SHORTCUT KEYS"),
        new ShortCut("OUTLOOK SHORTCUT KEYS")};

        for(int i=0;i<shortCuts.length;i++){
            list.add(shortCuts[i]);
        }

        ShortcutAdapter adapter=new ShortcutAdapter(getApplicationContext(),R.layout.shortcutkey_layout,list);
        ListView listView=(ListView)findViewById(R.id.list_data);

        listView.setAdapter(adapter);
       ArrayList arrayList=new ArrayList();
        arrayList.add("Alt + F -> File menu options in current program\n\n"+
                        "Alt + E -> Edit options in current program\n\n"+
                        "F1 -> Universal help (for all programs)\n\n");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                finish();
                Intent intent=new Intent(getApplicationContext(),ShortCutDetailActivity.class);
                intent.putExtra("shortcutposition",position);
                startActivity(intent);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
               return super.onOptionsItemSelected(item);
        }
    }
}
