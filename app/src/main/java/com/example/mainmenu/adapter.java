package com.example.mainmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<model> {

    Context context;

    ArrayList<model> list;

    public adapter(@NonNull Context context, ArrayList<model> list) {
        super(context,R.layout.demo,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       convertView= LayoutInflater.from(context).inflate(R.layout.demo,parent,false);
        ImageView img= convertView.findViewById(R.id.img);
        TextView text= convertView.findViewById(R.id.text);

        img.setImageResource(list.get(position).img);
        text.setText(list.get(position).name);
        return convertView;
    }
}
