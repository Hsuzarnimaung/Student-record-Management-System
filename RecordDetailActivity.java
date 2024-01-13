package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;

/**
 * Created by UCSM on 10/25/2016.
 */

public class RecordDetailActivity extends AppCompatActivity{






    TextView lblMajor;
    TextView lblAcademic;
     TextView lblid;
    TextView lblroll;
    TextView lblname;
    TextView lblgender;
    TextView lbldob;
    TextView lblfather;
    TextView lblclass;
    TextView lblsection;
    TextView lblphone;
    TextView lblemail;
    TextView lbladdress;
    TextView  detailPhone;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Detail Information");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));
        setContentView(R.layout.detail_list);
        lblid = (TextView) findViewById(R.id.lblid);
        lblroll = (TextView) findViewById(R.id.lblroll);
        lblname = (TextView) findViewById(R.id.lblname);
        lblgender = (TextView) findViewById(R.id.lblgender);
        lbldob = (TextView) findViewById(R.id.lbldob);
        lblfather = (TextView) findViewById(R.id.father);
        lblclass = (TextView) findViewById(R.id.lblclass);
        lblsection = (TextView) findViewById(R.id.lblsection);
        lblphone = (TextView) findViewById(R.id.lblphone);
        lblemail = (TextView) findViewById(R.id.lblemail);
        lbladdress = (TextView) findViewById(R.id.lbladdress);
        lblMajor = (TextView) findViewById(R.id.lblmajor);
        lblAcademic = (TextView) findViewById(R.id.lblacademic);
        detailPhone=(TextView)findViewById(R.id.detailphone);


        Intent i = getIntent();

         id= i.getIntExtra("databaseId", 1);
        //Toast.makeText(this, "id"+id, Toast.LENGTH_SHORT).show();
        DatabaseHandler dbHandler = new DatabaseHandler(this);
        Cursor cursor = dbHandler.getStudentData(id);
        cursor.moveToFirst();
        lblid.setText(cursor.getString(1));
        lblroll.setText(cursor.getString(2));
        lblname.setText(cursor.getString(3));
        lblgender.setText(cursor.getString(4));
        lbldob.setText(cursor.getString(5));
        lblfather.setText(cursor.getString(6));
        lblclass.setText(cursor.getString(7));
        lblMajor.setText(cursor.getString(8));
        lblsection.setText(cursor.getString(9));
        lblAcademic.setText(cursor.getString(10));
        lblphone.setText(cursor.getString(11));
        lblemail.setText(cursor.getString(12));
        lbladdress.setText(cursor.getString(13));
        detailPhone.setText(cursor.getString(11));
        cursor.close();

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
           /* default:
               return super.onOptionsItemSelected(item);*/
        }
        switch (item.getItemId()){
            case R.id.menuUpdate:
              getUpdateActivity();
              return true;

        }
        return super.onOptionsItemSelected(item);
    }
   /* @Override
   *//* public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }*//*
*/
    public void getUpdateActivity(){
        Intent intent=new Intent(getApplicationContext(),UpdateStudentDataActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("lblid",lblid.getText().toString());
        intent.putExtra("lblroll",lblroll.getText().toString());
        intent.putExtra("lblname",lblname.getText().toString());
        intent.putExtra("lblgender",lblgender.getText().toString());
        intent.putExtra("lbldob",lbldob.getText().toString());
        intent.putExtra("lblfather",lblfather.getText().toString());
        intent.putExtra("lblclass",lblclass.getText().toString());
        intent.putExtra("lblMajor",lblMajor.getText().toString());
        intent.putExtra("lblsection",lblsection.getText().toString());
        intent.putExtra("lblAcademic",lblAcademic.getText().toString());
        intent.putExtra("lblphone",lblphone.getText().toString());
        intent.putExtra("lblemail",lblemail.getText().toString());
        intent.putExtra("lbladdress",lbladdress.getText().toString());
        startActivity(intent);
        finish();
    }
    public void onBackPressed() {
        new RecordActivity().killRecord();
        Intent intent=new Intent(getApplicationContext(),RecordActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
    public void onClickCall(View view){
        Intent callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+lblphone.getText().toString()));
        startActivity(callIntent);
    }
    public void onClickSms(View view){
        Intent sendIntent=new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms_body","default content");
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
    }
}
