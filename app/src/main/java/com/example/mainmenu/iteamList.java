package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class iteamList extends AppCompatActivity {

    ListView listView;
    ArrayList<model> list;

    Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteam_list);

        listView = findViewById(R.id.List);
        list = new ArrayList<>();

        list.add(new model("Classic cupcakes✨",
                "No secret ingredients. Just a secret Japanese baking technique applied to classic butter cupcakes ingredients. It’s like…. magic!", R.drawable.vanilla));
        list.add(new model("themed cupcakes 🟪", "These moist chocolate cupcakes live up to their name" +
                " with an incredibly rich and bouncy texture with delicious chocolate flavor!", R.drawable.theme));
        list.add(new model("Birthday cupcakes 🎂", "These caramel cupcakes are the most decadent you can get. A light and fluffy vanilla cupcake" +
                " with a soft caramel center! " , R.drawable.birthday));
        list.add(new model("Anniversary👫", "Oreo Cupcakes with Cookies & Cream Oreo Frosting are decadent, delicious, and so much fun. " +
                "These cupcakes are light, airy, and super moist, filled with crumbled chocolate Oreo cookies!", R.drawable.anniversiry));
        list.add(new model("Valentine's day💌", "These Fresh Strawberry Cupcakes are moist," +
                " strawberry in the cupcake and they are topped with strawberry buttercream! ", R.drawable.valentine));
        list.add(new model("Graduation🎓", "These Fresh Strawberry Cupcakes are moist," +
                " strawberry in the cupcake and they are topped with strawberry buttercream! ", R.drawable.graduation));
        list.add(new model("Mother's day 🤱", "These Fresh Strawberry Cupcakes are moist," +
                " strawberry in the cupcake and they are topped with strawberry buttercream! ", R.drawable.mother));
        list.add(new model("new baby 👶", "These Fresh Strawberry Cupcakes are moist," +
                " strawberry in the cupcake and they are topped with strawberry buttercream! ", R.drawable.baby));

        adapter =new adapter(iteamList.this,list);
        listView.setAdapter((ListAdapter) adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(iteamList.this, Description.class);
                intent.putExtra("Name",list.get(position).name);
                intent.putExtra("Description",list.get(position).description);
                intent.putExtra("Img",list.get(position).img);
                startActivity(intent);


            }
        });
    }

}
