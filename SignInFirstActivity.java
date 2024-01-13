package com.example.ucsm.studentrecordmanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.Student;
import com.example.ucsm.studentrecordmanagement.model.Time;

/**
 * Created by UCSM on 10/21/2016.
 */

public class SignInFirstActivity extends AppCompatActivity {

    private Toolbar toolbar;

    EditText txtuser;
    EditText txtpass;

    Button signIn;
    Button cancel;

    DatabaseHandler db;
    Cursor c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtuser = (EditText) findViewById(R.id.userName);
        txtpass = (EditText) findViewById(R.id.passWord);

        signIn = (Button) findViewById(R.id.btnsave);
        cancel = (Button) findViewById(R.id.btncancel);
        //db.insertStudentData(new Student("324","2CS-2","Ma Ma","Female","10/12/1999","U Ba","Second Year","CS","A","2015-2016","09967183633","www","Tamu"));
        //db.insertStudentData(new Student("562","2CT-3","Mg Hla","Male","4/1/1998","U Kyaw Kyaw","Second Year","CT","A","2015-2016","09262512905","hla@email.com","Mandalay"));


//        String pin = c.getString(c.getColumnIndex("pin"));

       signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtuser.length()==0 && txtpass.length()==0) { Toast.makeText(getApplicationContext(),"Fill Form !! ",Toast.LENGTH_SHORT).show();}
                else {
                    db = new DatabaseHandler(getApplicationContext());
                    c = db.getSignUpData(1);
                    if (c.moveToFirst()) {

                        String user = c.getString(1);
                        String pass = c.getString(2);
                        if (txtuser.getText().toString().equals(user) && txtpass.getText().toString().equals(pass)) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("user_name", txtuser.getText().toString());
                            startActivity(intent);
                            finish();
                            if (getPreferences(MODE_PRIVATE).getBoolean("is_first_run", true)) {
                                db.insertStudentData(new Student("1234", "1CST-1", "Ma Ma", "Female", "18/4/1998", "U Ba", "First Year", "CST", "A", "2015-2016", "0933772917", "mama@email.com", "Manadaly"));
                                db.insertStudentData(new Student("1235", "1CST-2", "Zaw Zaw", "Male", "14/5/1998", "U Hla Htun", "First Year", "CST", "A", "2015-2016", "09259663245", "zawzaw@email.com", "Manadaly"));
                                db.insertStudentData(new Student("1236", "1CST-3", "Su Su", "Female", "10/8/1998", "U San", "First Year", "CST", "A", "2015-2016", "09459663245", "susu@email.com", "Manadaly"));
                                db.insertStudentData(new Student("1237", "1CST-4", "Mya Mya", "Female", "1/12/1998", "U Mya", "First Year", "CST", "A", "2015-2016", "09253221679", "myamya@email.com", "Manadaly"));
                                db.insertStudentData(new Student("1238", "1CST-5", "Aung Kyaw", "Male", "1/8/1998", "U Aung Aung", "First Year", "CST", "A", "2015-2016", "09259663245", "aungKyaw@email.com", "Manadaly"));
                                db.insertStudentData(new Student("1239", "1CST-6", "Phyo Phyo", "Male", "4/1/1998", "U Phyo", "First Year", "CST", "A", "2015-2016", "097796622", "phyophyo@email.com", "Manadaly"));
                                db.insertStudentData(new Student("1240", "1CST-1", "Myat thu", "Male", "8/8/1998", "U Maung", "First Year", "CST", "A", "2015-2016", "09452378", "myatthu@email.com", "Manadaly"));
                                db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "MON", "Eng", "Eng", "102", "Myanmar", "104", "101", "103"));
                                db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "TUE", "104", "101", "101", "Physics", "Physics", "Myanmar", "Myanmar"));
                                db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "WED", "102", "102", "104", "English", "103", "103", "Physics"));
                                db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "THU", "103", "Eng", "101", "Myanmar", "104", "102", "Physics"));
                                db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "FRI", "Myanmar", "103", "102", "Physics", "101", "104", "English"));
                                getPreferences(MODE_PRIVATE).edit().putBoolean("is_first_run", false).commit();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Input!!", Toast.LENGTH_SHORT).show();
                        }
                        c.close();

                    } else if (txtuser.getText().toString().equals("teacher") && txtpass.getText().toString().equals("123")) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("user_name", txtuser.getText().toString());
                        startActivity(intent);
                        finish();
                        if (getPreferences(MODE_PRIVATE).getBoolean("is_first_run", true)) {
                            db.insertStudentData(new Student("1234", "1CST-1", "Ma Ma", "Female", "18/4/1998", "U Ba", "First Year", "CST", "A", "2015-2016", "0933772917", "mama@email.com", "Manadaly"));
                            db.insertStudentData(new Student("1235", "1CST-2", "Zaw Zaw", "Male", "14/5/1998", "U Hla Htun", "First Year", "CST", "A", "2015-2016", "09259663245", "zawzaw@email.com", "Manadaly"));
                            db.insertStudentData(new Student("1236", "1CST-3", "Su Su", "Female", "10/8/1998", "U San", "First Year", "CST", "A", "2015-2016", "09459663245", "susu@email.com", "Manadaly"));
                            db.insertStudentData(new Student("1237", "1CST-4", "Mya Mya", "Female", "1/12/1998", "U Mya", "First Year", "CST", "A", "2015-2016", "09253221679", "myamya@email.com", "Manadaly"));
                            db.insertStudentData(new Student("1238", "1CST-5", "Aung Kyaw", "Male", "1/8/1998", "U Aung Aung", "First Year", "CST", "A", "2015-2016", "09259663245", "aungKyaw@email.com", "Manadaly"));
                            db.insertStudentData(new Student("1239", "1CST-6", "Phyo Phyo", "Male", "4/1/1998", "U Phyo", "First Year", "CST", "A", "2015-2016", "097796622", "phyophyo@email.com", "Manadaly"));
                            db.insertStudentData(new Student("1240", "1CST-1", "Myat thu", "Male", "8/8/1998", "U Maung", "First Year", "CST", "A", "2015-2016", "09452378", "myatthu@email.com", "Manadaly"));
                            db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "MON", "Eng", "Eng", "102", "Myanmar", "104", "101", "103"));
                            db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "TUE", "104", "101", "101", "Physics", "Physics", "Myanmar", "Myanmar"));
                            db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "WED", "102", "102", "104", "English", "103", "103", "Physics"));
                            db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "THU", "103", "Eng", "101", "Myanmar", "104", "102", "Physics"));
                            db.insertTime(new Time("2015-2016", "First Year", "CST", "A", "FRI", "Myanmar", "103", "102", "Physics", "101", "104", "English"));
                            getPreferences(MODE_PRIVATE).edit().putBoolean("is_first_run", false).commit();
                        }
                    } else {
                        AlertDialog.Builder adb = new AlertDialog.Builder(SignInFirstActivity.this);
                        adb.setTitle("Warning!!");
                        adb.setMessage("You have no account yet. Sing Up Now!!!");
                        adb.setPositiveButton("Sign Up", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                                startActivity(i);
                            }
                        });

                        adb.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SignInFirstActivity.this, "Menu Item can also be used to sign up", Toast.LENGTH_SHORT).show();
                            }
                        });
                        adb.show();
                    }


                }

                }



        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);

            }
        });
    }

   /* public boolean isTrue(){

        boolean test=false;

        for(Account ac : accountList) {
            if (txtuser.getText().toString().equals(ac.getUserName()) && txtpass.getText().toString().equals(ac.getPassWord())) {
                test=true;
            }else {
                test=false;
            }
        }
        return test;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.changePwd) {
            Intent intent = new Intent(this,ResetPwdActivity.class);
            intent.putExtra("userName",txtuser.getText().toString());
            startActivity(intent);
        }
        if(id==R.id.forgePass){
            db = new DatabaseHandler(getApplicationContext());
            c=db.getSignUpData(1);
            if(c.moveToFirst()) {
                String itemText = c.getString(1) + "|" + c.getString(3);
                c.moveToNext();
                Intent intent = new Intent(this, BackupPinActivity.class);
                intent.putExtra("backup", itemText);
                startActivity(intent);
            }else {Toast.makeText(getApplicationContext(),"You have no PIN yet!!",Toast.LENGTH_SHORT).show();}
        }
        if(id==R.id.exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
