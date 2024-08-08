package user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mainmenu.R;
import com.example.mainmenu.home_page;
import com.example.mainmenu.iteamList;

import admin_edit.admin_menu;

public class user_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        Button views = (Button) findViewById(R.id.viewproduct);
        Button buy = (Button) findViewById(R.id.buy_cake);
        Button log = (Button) findViewById(R.id.LOGs);
        Button order_view = (Button) findViewById(R.id.view_order);



        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view();
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buy();

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(user_main.this, "Logged out", Toast.LENGTH_LONG).show();
                logs();

            }
        });

    }
        public void view(){
            Intent intent =new Intent(this, iteamList.class);
            startActivity(intent);
        }

        public void buy(){
        Intent intent= new Intent(this, bill_activity.class);
        startActivity(intent);
        }

    public void logs(){
        Intent intent= new Intent(this, home_page.class);
        startActivity(intent);
    }
    }
