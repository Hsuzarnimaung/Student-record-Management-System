package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Student;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private static final int SETTINGS_RESULT = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initNavigationDrawer();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.setting) {

            Intent i = new Intent(getApplicationContext(), UserSettingActivity.class);
            startActivityForResult(i, SETTINGS_RESULT);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   /* protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==SETTINGS_RESULT){
            displayUserSettings();
        }
    }
   public void displayUserSettings()
    {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        String  settings = "";

        settings=settings+"Color: " + sharedPrefs.getString("prefUserPassword", "NOUPDATE");

        TextView textViewSetting = (TextView) findViewById(R.id.textViewSettings);
        textViewSetting.setText(settings);
    }*/

    public void initNavigationDrawer() {

        final NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id){

                    case R.id.formfill:
                        Intent intent2 =new Intent(MainActivity.this,FormFieldActivity.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.itemRecord:

                        Intent intent3 = new Intent(MainActivity.this,RecordActivity.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.itemClass:
                        Intent intent1 =new Intent(MainActivity.this,ClassAttendanceActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.timeTable:
                        //Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,ResultTimeTableActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.cuInformation:
                        Intent intent4=new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.shortcut:
                        Intent intent5=new Intent(MainActivity.this,ShortKeyActivity.class);
                        startActivity(intent5);
                        break;
                    case R.id.logout:
                        Intent i =new Intent(MainActivity.this,SignInFirstActivity.class);
                        startActivity(i);
                        finish();

                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        Bundle bd = getIntent().getExtras();
        String username = bd.getString("user_name");
        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        tv_email.setText(""+username+"");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


}