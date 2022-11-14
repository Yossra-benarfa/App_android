package com.example.myapplication;

import static com.google.android.gms.auth.api.signin.GoogleSignIn.getSignedInAccountFromIntent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;






public class Confirmation extends AppCompatActivity {
    EditText username,code;
    Button btnconfirme;
    DB myDB;
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);
        username=(EditText) findViewById(R.id.username);
        code=(EditText) findViewById(R.id.code);
        btnconfirme=(Button) findViewById(R.id.btnconfirme);
        myDB=new DB(this);

        btnconfirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String cod = code.getText().toString();
                if (user.equals("") || cod.equals("")) {
                    Toast.makeText(Confirmation.this,
                            "Please enter the credentials.", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = myDB.checkUserCode(user, cod);
                    System.out.println("result: " + result);
                    if (result == true) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Confirmation.this,
                                "Invalid credentials.", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });







    }




}
