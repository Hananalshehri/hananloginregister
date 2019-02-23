package com.example.hanaan.hananloginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    String name,family,Email,Passw,DOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }
    //Registration button
    public void userRegistration(View v){
        final EditText text = (EditText)findViewById(R.id.editText);
        final EditText text1 = (EditText)findViewById(R.id.editText2);
        final EditText text2 = (EditText)findViewById(R.id.editText3);
        final EditText text3 = (EditText)findViewById(R.id.editText4);
        final EditText text4 = (EditText)findViewById(R.id.editText5);
        name=text.getText().toString();
        family=text1.getText().toString();
        Email=text3.getText().toString().trim();
        Passw=text4.getText().toString();
        DOB=text2.getText().toString();
        //validation checks
        if(name.length()==0|| family.length()==0||Email.length()==0||Passw.length()==0||DOB.length()==0) {
            Toast.makeText(Register.this, "Enter all information, dont leave any field empty", Toast.LENGTH_SHORT).show();

        }
        else if
                (name.length()<3||name.length()>30){Toast.makeText(Register.this,"First name should be greter value than3 and less than 30", Toast.LENGTH_SHORT).show();
        }
        else
        {
//email validation check
            String email = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            //date check
            String regEx ="^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d{2}$";
            Matcher matcher = Pattern.compile(regEx).matcher(DOB);
            if (matcher.matches())
            {
                if (Email.matches(email)) {
                    Toast.makeText(Register.this, "Register Successfully through information", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Register.this, MainActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("fname", family);
                    intent.putExtra("email", Email );


                    setResult(RESULT_OK, intent);
                    finish();

                } else
                    Toast.makeText(Register.this, "Email not correct", Toast.LENGTH_SHORT).show();


            }
            else

                Toast.makeText(Register.this, "Date not correct", Toast.LENGTH_SHORT).show();

        }


    }
}

