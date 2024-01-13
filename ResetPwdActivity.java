package com.example.ucsm.studentrecordmanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.SignUp;

/**
 * Created by UCSM on 10/19/2016.
 */

public class ResetPwdActivity extends AppCompatActivity{

    Button btnOk,btnCancel;
    FloatingActionButton fb ;
    EditText txtCur,txtPwd,txtRpwd;
    Cursor c;
    String currenPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        btnOk=(Button) findViewById(R.id.btnSaveChange);
        btnCancel=(Button) findViewById(R.id.btnPwdCancel);

        fb=(FloatingActionButton) findViewById(R.id.fab);
        txtCur=(EditText) findViewById(R.id.currentPwd);
        txtPwd=(EditText) findViewById(R.id.newPwd);
        txtRpwd=(EditText) findViewById(R.id.reEnterPwd);

        Bundle bd = getIntent().getExtras();
       // final String username = bd.getString("userName");

        final DatabaseHandler db = new DatabaseHandler(getBaseContext());
        c=db.getSignUpData(1);
        if(c.moveToFirst()) {
            currenPass = c.getString(2).toString();
            //final String currentBackup = c.getString(3).toString();
        }else {
            Toast.makeText(this, "You didnot Sign Up", Toast.LENGTH_SHORT).show();
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCur.getText().toString().length() == 0 || txtPwd.getText().toString().length() == 0
                        || txtRpwd.getText().toString().length() == 0) {
                    if (txtCur.getText().toString().length() == 0 && txtPwd.getText().toString().length() != 0 && txtRpwd.getText().toString().length() != 0) {
                        Toast.makeText(getApplicationContext(), "Please!!Fill Current Password ", Toast.LENGTH_SHORT).show();
                    }
                    if (txtCur.getText().toString().length() != 0 && txtPwd.getText().toString().length() == 0 && txtRpwd.getText().length() != 0) {
                        Toast.makeText(getApplicationContext(), "Please!!Fill New Password ", Toast.LENGTH_SHORT).show();
                    }
                    if (txtCur.getText().length() != 0 && txtPwd.getText().length() != 0 && txtRpwd.getText().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please!!Fill Re-Enter Password ", Toast.LENGTH_SHORT).show();
                    }
                    if (txtCur.getText().length() == 0 && txtPwd.getText().length() == 0
                            && txtRpwd.getText().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please!!Fill All Fields", Toast.LENGTH_SHORT).show();
                    }
                    if(txtCur.getText().toString().length() == 0 && txtPwd.getText().toString().length() == 0 && txtRpwd.getText().toString().length() != 0){
                        Toast.makeText(getApplicationContext(), "Please!!Fill Current and \n New password ", Toast.LENGTH_SHORT).show();
                    }
                    if(txtCur.getText().toString().length() != 0 && txtPwd.getText().toString().length() == 0 && txtRpwd.getText().length() == 0){
                        Toast.makeText(getApplicationContext(), "Please!!Fill New and \n Re-Enter password ", Toast.LENGTH_SHORT).show();
                    }
                    if(txtCur.getText().length() == 0 && txtPwd.getText().length() != 0 && txtRpwd.getText().length() == 0){
                        Toast.makeText(getApplicationContext(), "Please!!Fill Current and \n Re-Enter password ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (txtCur.getText().toString().equals(currenPass) && txtPwd.getText().toString().equals(txtRpwd.getText().toString())) {
                        int upDate = db.updateSignUpData(new SignUp(1, c.getString(1), txtPwd.getText().toString(),c.getString(3)));
                       //Cursor c=db.getSignUpData(1);
                        if (upDate == 1) {
                            Toast.makeText(getApplicationContext(), "Update Complete!!", Toast.LENGTH_SHORT).show();
                            Log.i("Change password",c.getString(1)+"&&"+c.getString(2)+"&&"+c.getString(3));
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Update Fail!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCur.setText("");
                txtPwd.setText("");
                txtRpwd.setText("");

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
