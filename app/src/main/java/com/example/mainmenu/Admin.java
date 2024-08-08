package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import admin_edit.admin_menu;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        TextView A_username = (TextView) findViewById(R.id.btnUserName);
        TextView A_password = (TextView) findViewById(R.id.btnPassword);

        Button Login = (Button) findViewById(R.id.btnButton);
        Button back = (Button) findViewById(R.id.btnback4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openback();

            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A_username.getText().toString().equals("ADMIN") || A_username.getText().toString().equals("admin") && A_password.getText().toString().equals("123")) {
                    Toast.makeText(Admin.this, "Login", Toast.LENGTH_LONG).show();//correct login
                    menu();



                } else {
                    Toast.makeText(Admin.this, "Fail", Toast.LENGTH_LONG).show(); //invalid login
                }
            }


        });
    }

    public void menu(){

        Intent intent=new Intent(this, admin_menu.class);
        startActivity(intent);

    }


        public void openback(){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }


