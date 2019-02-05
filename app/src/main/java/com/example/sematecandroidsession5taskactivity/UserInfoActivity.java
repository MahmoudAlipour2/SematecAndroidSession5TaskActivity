package com.example.sematecandroidsession5taskactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    TextView tvNameTwo;
    TextView tvLastNameTwo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


        tvNameTwo = findViewById(R.id.tvNameTwo);
        tvLastNameTwo = findViewById(R.id.tvLastNameTwo);


        String takenName = PreferenceManager.getDefaultSharedPreferences(UserInfoActivity.this)
                .getString("SavedName", "Name Not Found !");
        String takenLastName = PreferenceManager.getDefaultSharedPreferences(UserInfoActivity.this)
                .getString("SavedLastName","Not Found LastName !");



        tvNameTwo.setText(takenName);
        tvLastNameTwo.setText(takenLastName);










    }
}
