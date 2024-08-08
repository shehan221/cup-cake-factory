package user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainmenu.MainActivity;
import com.example.mainmenu.R;

public class Register extends AppCompatActivity {

    DBHelper dbHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView c_username = (TextView) findViewById(R.id.btn_R_UserName);
        TextView c_password = (TextView) findViewById(R.id.btn_R_Password);
        TextView con_password = (TextView) findViewById(R.id.btn_R_conpassword);

        Button sign_in = (Button) findViewById(R.id.btn_R_Button);
        Button back = (Button) findViewById(R.id.btnback3);
        dbHelper = new DBHelper(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                back3();

            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username,password,confirm_p;

                username=c_username.getText().toString();
                password=c_password.getText().toString();
                confirm_p=con_password.getText().toString();

                if (username.equals("") || password.equals("") ||confirm_p.equals("")) {

                    Toast.makeText(Register.this, "fields can't be empty", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(confirm_p)) {
                        //success registration
                        boolean registration = dbHelper.InsertData(username, password);
                        if (registration) {
                            Toast.makeText(Register.this, "register success", Toast.LENGTH_LONG).show();
                            main();
                        }
                        else
                            Toast.makeText(Register.this, "Register Failed", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(Register.this, "password does not match", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void main(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }


        public void back3(){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);

        }

    }
