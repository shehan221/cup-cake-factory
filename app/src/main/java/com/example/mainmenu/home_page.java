package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button home=(Button) findViewById(R.id.home_page);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home();
            }
        });

    }

    public void home(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}