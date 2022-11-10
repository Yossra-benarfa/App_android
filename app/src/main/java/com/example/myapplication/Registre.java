package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Registre extends AppCompatActivity {
        EditText username,password,repassword;
        Button btnSignUp;
        Button btnsms;
        DB myDB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.registre);
            username=(EditText) findViewById(R.id.username);
            password=(EditText) findViewById(R.id.password);
            repassword=(EditText) findViewById(R.id.repassword);

            btnSignUp =(Button) findViewById(R.id.btnSignUp);

            myDB=new DB(this);
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    String repass = repassword.getText().toString();
                    if(user.trim().equals("")||pass.trim().equals("")||repass.trim().equals(""))

                    {
                        Toast.makeText(Registre.this,
                                "Fill all the fields.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(pass.equals(repass))
                        {
                            Boolean usercheckResult = myDB.checkusername(user);
                            if(usercheckResult == false)
                            {
                                Boolean regResult = myDB.insertData(user,pass);
                                if(regResult== true){
                                    Toast.makeText(Registre.this, "Registration Succesfull ", Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(Registre.this, "Registration Failed ", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else {
                                Toast.makeText(Registre.this, "User Already exists/ Please SignIn. ", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(Registre.this, "Password not Matching. ", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

            });

        }
    }

