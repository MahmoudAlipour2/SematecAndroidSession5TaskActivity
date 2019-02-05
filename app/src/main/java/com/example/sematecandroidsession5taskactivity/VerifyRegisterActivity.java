package com.example.sematecandroidsession5taskactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VerifyRegisterActivity extends AppCompatActivity {

    /*Define Variables*/
    TextView tvName;
    TextView tvNameTwo;
    TextView tvLastName;
    TextView tvLastNameTwo;
    Button btnOkVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_register);



        /*Bind View elements and Variables*/
        tvName = findViewById(R.id.tvName);
        tvNameTwo = findViewById(R.id.tvNameTwo);
        tvLastName = findViewById(R.id.tvLastName);
        tvLastNameTwo = findViewById(R.id.tvLastNameTwo);
        btnOkVerify = findViewById(R.id.btnOkVerify);



        /*Get data from Registration Activity*/
        Bundle getDataFromRegistration = getIntent().getExtras();
        final String getName = getDataFromRegistration.getString("Name");
        final String getLastName = getDataFromRegistration.getString("LastName");


        //Put data to Text Views
        tvNameTwo.setText(getName);
        tvLastNameTwo.setText(getLastName);

        /*Save Data if User Press the btnOkVerify*/
        btnOkVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Saveing Data's */
                PreferenceManager.getDefaultSharedPreferences(VerifyRegisterActivity.this).edit()
                        .putString("SavedName", getName).apply();
                PreferenceManager.getDefaultSharedPreferences(VerifyRegisterActivity.this).edit()
                        .putString("SavedLastName", getLastName).apply();


                /*Toast; Your Information Saved Successfully!*/
                Toast.makeText(VerifyRegisterActivity.this, "Your Information Saved Successfully!", Toast.LENGTH_LONG).show();


                /*Pass Name to MainActivity*/
                Intent VerifyRegistertoMain = new Intent(VerifyRegisterActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Name", getName);
                VerifyRegistertoMain.putExtras(bundle);
                startActivity(VerifyRegistertoMain);
            }
        });


    }
}
