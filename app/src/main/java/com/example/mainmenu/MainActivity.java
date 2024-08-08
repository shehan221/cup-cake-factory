package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import user.Register;
import user.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set click listeners for profile icons
        ImageView adminIcon = findViewById(R.id.imgAdmin);
        ImageView userIcon = findViewById(R.id.imgUser);
        ImageView registerIcon = findViewById(R.id.imgRegister);

        adminIcon.setOnClickListener(this);
        userIcon.setOnClickListener(this);
        registerIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgAdmin) {
            openAdmin();
        } else if (v.getId() == R.id.imgUser) {
            openUser();
        } else if (v.getId() == R.id.imgRegister) {
            openRegister();
        }
    }

    public void openAdmin() {
        Intent intent = new Intent(this, Admin.class);
        startActivity(intent);
    }

    public void openUser(){
        Intent intent = new Intent(this, User.class);
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
