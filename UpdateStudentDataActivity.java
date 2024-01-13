package com.example.ucsm.studentrecordmanagement;

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
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Student;


/**
 * Created by UCSM on 10/27/2016.
 */

public class UpdateStudentDataActivity extends AppCompatActivity {
    EditText updateId;
    EditText updateRollno;
    EditText updatename;

    EditText updatedob;
    EditText updatefather;
    EditText updateclass;
    EditText updatemajor;
    EditText updatesection;
    EditText updateacademic;
    EditText updatephoneno;
    EditText updateemail;
    EditText updateaddress;
    RadioButton rdomale;
    RadioButton rdofemale;
    String updategender;
    String lblid;
    String lblRollno;
    String lblname;
    String lbldob;
    String lblfather;
    String lblclass;
    String lblmajor;
    String lblsection;
    String lblacademic;
    String lblphoneno;
    String lblemail;
    String lbladdress;
    String lblgender;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_update);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Update Form");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

       updateId=(EditText)findViewById(R.id.updateId);
        updateRollno=(EditText)findViewById(R.id.updateRoll);
        updatename=(EditText)findViewById(R.id.updateName);
       updatedob=(EditText)findViewById(R.id.updateDob);
        updatefather=(EditText)findViewById(R.id.updateFather);
        updateclass=(EditText)findViewById(R.id.updateClass);
        updatemajor=(EditText)findViewById(R.id.updateMajor);
        updatesection=(EditText)findViewById(R.id.updateSection);
        updateacademic=(EditText)findViewById(R.id.updateAcademic);
        updatephoneno=(EditText)findViewById(R.id.updatePhone);
        updateemail=(EditText)findViewById(R.id.updateEmail);
        updateaddress=(EditText)findViewById(R.id.updateAddress);
        rdomale=(RadioButton)findViewById(R.id.updateFemale);
        rdofemale=(RadioButton)findViewById(R.id.updateMale);


       //startActivity(intent1);


        Intent i=getIntent();
        id=i.getIntExtra("id",1);
        lblid=i.getStringExtra("lblid");
        lblRollno=i.getStringExtra("lblroll");
        lblname=i.getStringExtra("lblname");
        lbldob=i.getStringExtra("lbldob");
        lblfather=i.getStringExtra("lblclass");
        lblclass=i.getStringExtra("lblclass");
        lblmajor=i.getStringExtra("lblMajor");
        lblsection=i.getStringExtra("lblsection");
        lblacademic=i.getStringExtra("lblAcademic");
        lblphoneno=i.getStringExtra("lblphone");
        lblemail=i.getStringExtra("lblemail");
        lbladdress=i.getStringExtra("lbladdress");
        lblgender=i.getStringExtra("lblgender");

       /* if(lblgender.equals("Female")){
            rdomale.setChecked(false);
            rdofemale.setChecked(true);
        }else {
            rdofemale.setChecked(false);
            rdomale.setChecked(true);
        }*/

        updateId.setText(lblid);
        updateRollno.setText(lblRollno);
        updatename.setText(lblname);
        updatedob.setText(lbldob);
        updatefather.setText(lblfather);
        updateclass.setText(lblclass);
        updatemajor.setText(lblmajor);
        updatesection.setText(lblsection);
        updateacademic.setText(lblacademic);
        updatephoneno.setText(lblphoneno);
        updateemail.setText(lblemail);
        updateaddress.setText(lbladdress);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.update,menu);
        return super.onCreateOptionsMenu(menu);
    }



    public void onchooseRdo(View view){
        boolean result=((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.updateMale:
                if(result){
                    updategender="Male";
                    //Toast.makeText(this, "You selected male", Toast.LENGTH_SHORT).show();
                    }
                break;
            case R.id.updateFemale:
                if(result){
                    updategender="Female";
                   // Toast.makeText(this, "You selected Female", Toast.LENGTH_SHORT).show();
                    }
                break;
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

        switch (item.getItemId()){

            case R.id.cancelmenu:
                finish();
                Intent intent=new Intent(getBaseContext(),RecordDetailActivity.class);
                startActivity(intent);
                return true;
            case R.id.savemenu:
                finish();
                updateStudentData();
                Intent intent1=new Intent(getBaseContext(),RecordDetailActivity.class);
                startActivity(intent1);

                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    public void updateStudentData(){

       Student student=new Student(id,updateId.getText().toString()
                ,updateRollno.getText().toString()
                ,updatename.getText().toString(),
                updategender,
                updatedob.getText().toString()
                ,updatefather.getText().toString()
                ,updateclass.getText().toString()
                ,updatemajor.getText().toString()
                ,updatesection.getText().toString()
                ,updateacademic.getText().toString()
                ,updatephoneno.getText().toString()
                ,updateemail.getText().toString()
                ,updateaddress.getText().toString());
        DatabaseHandler db=new DatabaseHandler(getBaseContext());
        db.updateStudentData(student);
        Log.i("output : ",updateId.getText().toString()+"&&"+updategender);



    }

    @Override
    public void onBackPressed() {
        Intent intent1=new Intent(getBaseContext(),RecordDetailActivity.class);
        startActivity(intent1);
        super.onBackPressed();
    }
}
