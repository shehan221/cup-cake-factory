package admin_edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mainmenu.Admin;
import com.example.mainmenu.R;
import com.example.mainmenu.home_page;
import com.example.mainmenu.iteamList;

public class admin_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        Button deldata = (Button) findViewById(R.id.del1);
        Button adddata = (Button) findViewById(R.id.add1);
        Button addcate=(Button)findViewById(R.id.add2);
        Button view = (Button) findViewById(R.id.view);
        Button logout = (Button) findViewById(R.id.lOGOUT);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view();

            }
        });



        deldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delete();


            }

        });



        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCa=new Intent(admin_menu.this, AddcupcakeActivity.class);
                startActivity(intentCa);
            }
        });

        addcate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCategory=new Intent(admin_menu.this, AddcategoryActivity.class);
                startActivity(intentCategory);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(admin_menu.this, "Logged out", Toast.LENGTH_LONG).show();
                logout();


            }
        });

}

        public void delete(){
            Intent intent =new Intent(this,delete.class);
            startActivity(intent);
        }

        public void logout(){
            Intent intent =new Intent(this, home_page.class);
            startActivity(intent);
        }



    public void view(){
        Intent intent =new Intent(this, iteamList.class);
        startActivity(intent);
    }

}