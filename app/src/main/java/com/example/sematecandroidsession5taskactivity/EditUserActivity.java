package com.example.sematecandroidsession5taskactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUserActivity extends AppCompatActivity {

    /*Define Variables*/

    EditText etName;
    EditText etLastName;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        /*Bind Variables and View elements*/
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        btnSave = findViewById(R.id.btnSave);

        /*Take data from hard with preferencesManager Command.*/
        final String TakenName = PreferenceManager.getDefaultSharedPreferences(EditUserActivity.this)
                .getString("SavedName", "NotFoundName");

        final String TakenLastName = PreferenceManager.getDefaultSharedPreferences(EditUserActivity.this)
                .getString("SavedLastName", "NotFoundLastName");


        etName.setText(TakenName);
        etLastName.setText(TakenLastName);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*Get Name and LastName*/
                String getName = etName.getText().toString();
                String getLastName = etLastName.getText().toString();


                PreferenceManager.getDefaultSharedPreferences(EditUserActivity.this).edit()
                        .putString("SavedName", getName).apply();

                PreferenceManager.getDefaultSharedPreferences(EditUserActivity.this).edit()
                        .putString("SavedLastName", getLastName).apply();

                Toast.makeText(EditUserActivity.this, "Saved Your Information Successfully!", Toast.LENGTH_LONG).show();


                Intent EdittoMain = new Intent();
                EdittoMain.putExtra("Name", getName);
                setResult(MainActivity.RESULT_OK, EdittoMain);


                finish();


            }
        });


    }
}
