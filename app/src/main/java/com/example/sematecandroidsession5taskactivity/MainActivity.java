package com.example.sematecandroidsession5taskactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Define Variable*/
    TextView tvHiUser;
    Button btnRegister;
    Button btnUserInfo;
    Button btnEditUser;
    String takenName;
    String notFound = "NotFound";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*findViewById*/

        tvHiUser = findViewById(R.id.tvHiUser);
        btnRegister = findViewById(R.id.btnRegister);
        btnUserInfo = findViewById(R.id.btnUserInfo);
        btnEditUser = findViewById(R.id.btnEditInfo);

        takenName = PreferenceManager.getDefaultSharedPreferences(MainActivity.this)
                .getString("SavedName", "NotFound");

        if (takenName.equals(notFound)) {
            tvHiUser.setText("Hi User");
        } else {

            tvHiUser.setText("Hi " + takenName);
        }

        /*Binding Between MainActivity and RegisterActivity*/
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent MaintoRegister = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(MaintoRegister);

            }
        });




        /*Binding Between MainActivity and UserInfoActivity*/
        btnEditUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent- startActivityForResult-Code=500*/
                Intent MaintoEditInfo = new Intent(MainActivity.this, EditUserActivity.class);
                startActivityForResult(MaintoEditInfo, 500);
            }
        });




        /*Binding Between MainActivity and EditInfoActivity*/
        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent- startActivity- Passing Multi data's*/
                Intent MaintoUserInfo = new Intent(MainActivity.this,UserInfoActivity.class);
                startActivity(MaintoUserInfo);



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 500) {
            if (resultCode == Activity.RESULT_OK) {

                takenName = data.getStringExtra("Name");
                tvHiUser.setText("Hi " + takenName);

            }

        }
    }


}
