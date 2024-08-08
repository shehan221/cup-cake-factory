package user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainmenu.ActivityProducts;
import com.example.mainmenu.MainActivity;
import com.example.mainmenu.R;

public class User extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        TextView uName = (TextView) findViewById(R.id.txt_U_name);
        TextView uPass = (TextView) findViewById(R.id.txt_U_password);

        Button uLogin = (Button) findViewById(R.id.btn_U_button);
        Button back2 = (Button) findViewById(R.id.btnback2);
        dbHelper = new DBHelper (this);


        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openback();

            }
        });


        uLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isLoggedId = dbHelper.checkUser(uName.getText().toString(), uPass.getText().toString());

                if(isLoggedId) {
                    Toast.makeText(User.this, "Login Successful!", Toast.LENGTH_LONG).show();
                    user_main();
                } else {
                    Toast.makeText(User.this, "Login failed due to incorrect Username or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
        public void openback(){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        public void user_main(){
        Intent intent=new Intent(this, user_main.class);
        startActivity(intent);
        }

    }

