package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

/**
 * Created by UCSM on 11/1/2016.
 */

public class BackupPinActivity extends AppCompatActivity {

    EditText editPIN;
    String txt,user,pin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backup_pin_layout);
        editPIN = (EditText) findViewById(R.id.txtPIN);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Forget Password?");
        actionBar.setElevation(6);

        Bundle bundle = getIntent().getExtras();
       txt = bundle.getString("backup");

        StringTokenizer st = new StringTokenizer(txt,"|");
        user=st.nextToken();
        pin=st.nextToken();

    }
    public void onClickPIN(View view){
        if(editPIN.getText().toString().equals(pin)){
            Intent intent =new Intent(this,MainActivity.class);
            intent.putExtra("user_name",user);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(getApplicationContext(),"Doesnot match PIN!Try again!!",Toast.LENGTH_SHORT).show();
        }
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
