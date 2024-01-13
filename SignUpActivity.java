package com.example.ucsm.studentrecordmanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ucsm.studentrecordmanagement.database.DatabaseHandler;
import com.example.ucsm.studentrecordmanagement.model.SignUp;

import java.util.List;

/**
 * Created by UCSM on 10/20/2016.
 */

public class SignUpActivity extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4;

    Button btn1,btn2;

    FloatingActionButton fbUp ;

    List<SignUp> lstSign;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        edit1 = (EditText) findViewById(R.id.username);
        edit2 = (EditText) findViewById(R.id.password);
        edit3 = (EditText) findViewById(R.id.rePassword);
        edit4 = (EditText) findViewById(R.id.backupPin);

        btn1 = (Button) findViewById(R.id.btnSaveUp);
        btn2 = (Button) findViewById(R.id.btnCancelUp);

        fbUp = (FloatingActionButton) findViewById(R.id.fabUp);

        final DatabaseHandler handler =new DatabaseHandler(this);
        final SignUp account = new SignUp();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.getText().toString().length()==0 || edit2.getText().toString().length()==0
                        || edit3.getText().toString().length()==0 || edit4.getText().toString().length()==0){
                    if(edit1.getText().toString().length()==0 && edit2.getText().toString().length()!=0 && edit3.getText().toString().length()!=0){
                        Toast.makeText(getApplicationContext(),"Please!!Fill Username Field",Toast.LENGTH_SHORT).show();
                    }
                    if(edit1.getText().toString().length()!=0 && edit2.getText().toString().length()==0 && edit3.getText().length()!=0){
                        Toast.makeText(getApplicationContext(),"Please!!Fill Password Field",Toast.LENGTH_SHORT).show();
                    }
                    if(edit1.getText().length()!=0 && edit2.getText().length()!=0 && edit3.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please!!Fill Re-Enter Password Field",Toast.LENGTH_SHORT).show();
                    }
                    if(edit1.getText().length()==0 && edit2.getText().length()==0
                            && edit3.getText().length()==0){
                        Toast.makeText(getApplicationContext(),"Please!!Fill All Fields" ,Toast.LENGTH_SHORT).show();
                    }
                    if(edit1.getText().toString().length() == 0 && edit2.getText().toString().length() == 0 && edit3.getText().toString().length() != 0){
                        Toast.makeText(getApplicationContext(), "Please!!Fill User and \n  password Fields", Toast.LENGTH_SHORT).show();
                    }
                    if(edit1.getText().toString().length() != 0 && edit2.getText().toString().length() == 0 && edit3.getText().length() == 0){
                        Toast.makeText(getApplicationContext(), "Please!!Fill Password and \n Re-Enter password Fields ", Toast.LENGTH_SHORT).show();
                    }
                    if(edit4.getText().length()==0){Toast.makeText(getApplicationContext(),"Fill Back-up PIN Field",Toast.LENGTH_SHORT).show();}
                    if(edit1.getText().length() == 0 && edit2.getText().length() != 0 && edit3.getText().length() == 0){
                        Toast.makeText(getApplicationContext(), "Please!!Fill Username and \n Re-Enter password Fields ", Toast.LENGTH_SHORT).show();
                    }
                }else {

                    if (edit2.getText().toString().equals(edit3.getText().toString())) {
                        account.setSignUpName(edit1.getText().toString());
                        account.setSignUpPassword(edit2.getText().toString());
                        account.setBackup(edit4.getText().toString());
                        handler.insertSignUpData(account);
                        lstSign =handler.getAllSignUpData();
                        for(SignUp up: lstSign){
                             String test = up.getSignUpName()+"|"+up.getSignUpPassword()+"|"+up.getBackup();
                        Log.i("Test >> ",test);
                        }
                        Toast.makeText(getApplicationContext(),"Record Successfully!!",Toast.LENGTH_SHORT).show();
                        /*String test = cursor.getString(cursor.getColumnIndex("username"))+":"+cursor.getString(cursor.getColumnIndex("password"))+
                                cursor.getString(cursor.getColumnIndex("pin"));
                        Log.i("Test >> ",test);
*/
                    }else {
                        Toast.makeText(getApplicationContext(), " Not Match Password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText("");
                edit2.setText("");
                edit3.setText("");
            }
        });

        fbUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
