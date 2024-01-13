package com.example.ucsm.studentrecordmanagement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Student;

import java.util.Calendar;

/**
 * Created by UCSM on 10/24/2016.
 */

public class FormFieldActivity extends AppCompatActivity {

    Toolbar toolbar;

    EditText txtId;
    EditText txtRoll;
    EditText txtName;

    EditText txtDob;
    EditText txtFather;
    EditText txtClass;
    EditText txtSection;
    EditText txtPhone;
    EditText txtEmail;
    EditText txtAddress;
    EditText txtMajor;
    EditText txtAcademic;

    RadioButton rdbMale;
    RadioButton rdbFemale;
    String studentId;
    String studentRoll;
    String studentName;
    String studentDob;
    String studentFather;
    String studentClass;
    String studentSection;
    String studentPhone;
    String studentEmail;
    String studentGender;
    String studentAddress;
    String studentMajor;
    String studentAcademic;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Registration Form");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));

        rdbMale=(RadioButton) findViewById(R.id.rdoMale);
        rdbFemale=(RadioButton) findViewById(R.id.rdoFemale);

        txtId = (EditText) findViewById(R.id.txtId);
        txtRoll = (EditText) findViewById(R.id.txtRoll);
        txtName = (EditText) findViewById(R.id.txtName);
        txtDob = (EditText) findViewById(R.id.txtDob);
        txtFather = (EditText) findViewById(R.id.txtFather);
        txtClass = (EditText) findViewById(R.id.txtClass);
        txtSection = (EditText) findViewById(R.id.txtSection);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtAddress=(EditText)findViewById(R.id.txtAddress);
        txtMajor=(EditText)findViewById(R.id.txtMajor);
        txtAcademic=(EditText)findViewById(R.id.txtAcademic);

      /*  txtDob.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                    Calendar calendar=Calendar.getInstance();
                    int year=calendar.get(Calendar.YEAR);
                    int month=calendar.get(Calendar.MONTH);
                    int day=calendar.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog dpg=new DatePickerDialog(FormFieldActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDob.setText(dayOfMonth+"/"+month+"/"+year);
                        }
                    },year,month,day);
                    dpg.show();

                return true;
            }
        });
*/



        txtDob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(txtDob.isFocused() )
                {

                    Calendar calendar=Calendar.getInstance();
                    int year=calendar.get(Calendar.YEAR);
                    int month=calendar.get(Calendar.MONTH);
                    int day=calendar.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog dpg=new DatePickerDialog(FormFieldActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDob.setText(dayOfMonth+"/"+month+"/"+year);
                        }
                    },year,month,day);
                    dpg.show();
                }
            }
        });
        txtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDob.isFocused() )
                {

                    Calendar calendar=Calendar.getInstance();
                    int year=calendar.get(Calendar.YEAR);
                    int month=calendar.get(Calendar.MONTH);
                    int day=calendar.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog dpg=new DatePickerDialog(FormFieldActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDob.setText(dayOfMonth+"/"+month+"/"+year);
                        }
                    },year,month,day);
                    dpg.show();
                }
            }
        });
    }

    public void onclickRdo(View view){
        boolean result=((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.rdoMale:
                if(result){
                    studentGender="Male";}
                break;
            case R.id.rdoFemale:
                if(result){
                    studentGender="Female";}
                break;
        }
    }
    public void onSave(View view){


        studentId=txtId.getText().toString();
        studentRoll=txtRoll.getText().toString();
        studentName=txtName.getText().toString();
        studentGender=Gender();
        studentDob=txtDob.getText().toString();
        studentFather=txtFather.getText().toString();
        studentClass=txtClass.getText().toString();
        studentSection=txtSection.getText().toString();
        studentPhone=txtPhone.getText().toString();
        studentEmail=txtEmail.getText().toString();
        studentAddress=txtAddress.getText().toString();
        studentMajor=txtMajor.getText().toString();
        studentAcademic=txtAcademic.getText().toString();


        if(studentId.length()!=0&&studentRoll.length()!=0
                &&studentName.length()!=0&&studentDob.length()!=0
                &&studentFather.length()!=0&&studentClass.length()!=0
                &&studentSection.length()!=0&&studentPhone.length()!=0
                &&studentEmail.length()!=0&&studentAddress.length()!=0&&studentAcademic.length()!=0&&studentMajor.length()!=0){

            int result=studentEmail.indexOf("@");

            int result2=studentEmail.indexOf(".com");

            if(result!=-1 && result2!=-1) {


                DatabaseHandler dbhandler = new DatabaseHandler(this);

                dbhandler.insertStudentData(new Student(studentId, studentRoll,
                        studentName, studentGender, studentDob,
                        studentFather, studentClass, studentMajor,
                        studentSection, studentAcademic, studentPhone, studentEmail, studentAddress));

                Intent intent = new Intent(getApplicationContext(), RecordActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this,"Email format invalid!!",Toast.LENGTH_SHORT).show();}

        }else { Toast.makeText(getApplicationContext(),"Fill form completely!!",Toast.LENGTH_SHORT).show();}


    }
    public void killFormField(){
        finish();
    }
   public void onCancel(View view){
       Intent intent=new Intent(getApplicationContext(),RecordActivity.class);
       startActivity(intent);

       finish();
   }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(getApplicationContext(),RecordActivity.class);
        startActivity(intent);

        super.onBackPressed();
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
    public String Gender(){
        String gender = null;
        boolean male = rdbMale.isChecked();
        boolean female = rdbFemale.isChecked();
        if(male){
            gender = "Male";
        }
        if(female){
            gender="Female";
        }
        return gender;
    }
    }
