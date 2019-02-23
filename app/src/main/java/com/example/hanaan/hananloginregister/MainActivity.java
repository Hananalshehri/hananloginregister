package com.example.hanaan.hananloginregister;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

int assignvalue=0;
    String firstname,family,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Signed button text
    public void SignedUp(View view){
        Intent intent=new Intent(MainActivity.this,Register.class);
        startActivityForResult(intent, 1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {


            if (resultCode == RESULT_OK) {

                assignvalue = 1;
                firstname = data.getStringExtra("name");
                family = data.getStringExtra("fname");
                email=data.getStringExtra("email");

                Toast.makeText(MainActivity.this, firstname, Toast.LENGTH_SHORT).show();

            }
        }}
    public void Signin(View view){
        if(assignvalue==0){
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(MainActivity.this);
            }
            builder.setTitle("Login/Register")
                    .setMessage("Login disabled you need to register at first to enable login")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            // continue with delete
                        }
                    }).setIcon(R.drawable.login)
                    .show();
        }
        if(assignvalue==1){
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(MainActivity.this);
            }
            builder.setTitle("Login/Register")
                    .setMessage("LoginEnabled: your Profile view Firstname = "+  firstname + "Family name is" +family+" Yours email is "+ email )

                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            // continue with delete
                        }
                    })

                    .setIcon(R.drawable.login)
                    .show();
    }
}}
