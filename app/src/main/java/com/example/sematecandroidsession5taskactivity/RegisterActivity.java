package com.example.sematecandroidsession5taskactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class RegisterActivity extends AppCompatActivity {


    /*Define Variables*/

    EditText etName;
    EditText etLastName;
    Button btnRegister;

    /*OnCreate*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        /*Bind Variable and View elements*/

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        btnRegister = findViewById(R.id.btnRegister);



        /*OnClick*/

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*Get text from Edit Texts*/

                final String getTxtName = etName.getText().toString();
                final String getTxtLastName = etLastName.getText().toString();


                /*Passing data to VerifyRegistrationActivity*/

                Intent RegisterToVerifyRegister = new Intent(RegisterActivity.this, VerifyRegisterActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Name", getTxtName);
                bundle.putString("LastName", getTxtLastName);
                RegisterToVerifyRegister.putExtras(bundle);
                startActivity(RegisterToVerifyRegister);

            }
        });

    }
}
