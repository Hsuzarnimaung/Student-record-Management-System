package com.example.ucsm.studentrecordmanagement;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.ucsm.studentrecordmanagement.adapter.StudentAdapter;
import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;


/**
 * Created by UCSM on 10/24/2016.
 */

public class RecordActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    boolean checker = false;
    Menu menu;
    Toolbar toolbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Record List");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        //actionBar.inflateMenu(R.menu.menu);
        final DatabaseHandler dbhandler = new DatabaseHandler(this);


        listView = (ListView) findViewById(R.id.list_data);

        StudentAdapter adapter = new StudentAdapter(RecordActivity.this, dbhandler.getAllStudentData());

        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                checker = true;


                AlertDialog.Builder ad = new AlertDialog.Builder(RecordActivity.this);
                ad.setTitle("Delete");
                ad.setMessage("Sure you want to delete record ?");
                final int pos = (int) (id);

                //Toast.makeText(RecordActivity.this, "out"+id, Toast.LENGTH_SHORT).show();
                ad.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        DatabaseHandler db = new DatabaseHandler(getBaseContext());
                        db.deleteStudentData(pos);

                        StudentAdapter adapter = new StudentAdapter(getBaseContext(), db.getAllStudentData());

                        listView.setAdapter(adapter);


                    }
                });
                ad.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();
                return false;
            }


        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (!checker) {


                    Intent intent = new Intent(getBaseContext(), RecordDetailActivity.class);
                    //Toast.makeText(RecordActivity.this, "id : "+id, Toast.LENGTH_SHORT).show();
                    intent.putExtra("databaseId", (int) id);
                    startActivity(intent);
                    finish();
                }

                checker = false;

            }
        });

    }

    public void killRecord() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchData(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    //  @Override


    //@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        this.menu=menu;

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.HONEYCOMB) {
            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView)menu.findItem(R.id.action_search).getActionView();
            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    searchData(newText);
                    return false;
                }
            });

        }
        return super.onCreateOptionsMenu(menu);
    }
*/


    public void searchData(String newText) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            DatabaseHandler db = new DatabaseHandler(getBaseContext());
            StudentAdapter adapter = new StudentAdapter(getBaseContext(), db.searchData(newText));
            listView.setAdapter(adapter);

            //SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            //SearchView search = (SearchView)menu.findItem(R.id.action_search).getActionView();

        }

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
            case R.id.delete:
                finish();
                Intent intent = new Intent(getApplicationContext(), DeleteListViewActivity.class);
                startActivity(intent);
                return true;
            case R.id.addData:
                finish();
                Intent intent1 = new Intent(getApplicationContext(), FormFieldActivity.class);
                startActivity(intent1);
                return true;
            case R.id.action_search:


        }
        return super.onOptionsItemSelected(item);
    }


}
