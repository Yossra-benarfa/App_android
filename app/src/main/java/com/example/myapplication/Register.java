package com.example.myapplication;


import
        androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Register extends AppCompatActivity {
        EditText username,password,repassword , code, confirmer;
        Button btnSignUp;

        Button btnloginn;
        DB myDB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.registre);
            username=(EditText) findViewById(R.id.username);
            password=(EditText) findViewById(R.id.password);
            repassword=(EditText) findViewById(R.id.repassword);
            btnloginn=(Button) findViewById(R.id.btnloginn);
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
                        Toast.makeText(Register.this,
                                "Fill all the fields.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(pass.equals(repass))
                        {
                            Boolean usercheckResult = myDB.checkusername(user);
                            if(usercheckResult == false)
                            {
                                String code = Utils.generateRandomHexToken(8);
                                Boolean regResult = myDB.insertData(user,pass, code);
                                if(regResult== true){
                                   // Utils.sendMailToUser(user, code);
                                    sendMail(
                                            user,
                                            "Your code is " + code,
                                            "FatControll Aplication"
                                    );
                                    Toast.makeText(Register.this, "Register with success, please check your email code! ", Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(getApplicationContext(),Confirmation.class);


                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(Register.this, "Registration Failed ", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else {
                                Toast.makeText(Register.this, "User Already exists/ Please SignIn. ", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(Register.this, "Password not Matching. ", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

            });
            btnloginn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(getApplicationContext(),Login.class);


                    startActivity(intent);


                }
            });
        }

        private void sendMail(String mail, String  message, String subject) {

        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,subject,message);

        javaMailAPI.execute();

    }}


