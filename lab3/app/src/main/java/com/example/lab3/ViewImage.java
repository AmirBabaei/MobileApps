package com.example.lab3;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewImage extends AppCompatActivity {

    DBhandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        db = MainActivity.db;
        imageObject[] pics;
        pics = db.view();


        for (int i = 0; i < pics.length; i++) {

            LinearLayout images = findViewById(R.id.images);
            LayoutInflater inflater = LayoutInflater.from(this);
            View view = inflater.inflate(R.layout.imageob, images, false);

            ImageView imageView = view.findViewById(R.id.imagep);
            TextView name = view.findViewById(R.id.imagetitle);


            if(pics[i] != null){
                imageView.setImageBitmap(pics[i].getBmp());
                name.setText(pics[i].getTitle());

            }
            images.addView(view);
        }
    }
}
