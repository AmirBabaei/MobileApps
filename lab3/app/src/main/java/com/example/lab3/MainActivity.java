package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    static String titlename;

    public static DBhandler db;
    public static Bitmap bmap;



    public static void setImageBitmap(Bitmap imageBitmap) {
        MainActivity.bmap = imageBitmap;
    }

    public static Bitmap getImageBitmap() {
        return bmap;
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBhandler(this, "IMAGE_LIB", null, 1);

    }


    public static void insertIntoDb()
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmap.compress(Bitmap.CompressFormat.JPEG, 15, stream);
        byte[] bArray = stream.toByteArray();
        db.insert(titlename, bArray);
        bmap.recycle();
    }

    public void download(View view) {
        Intent intent = new Intent(MainActivity.this, download.class);
        startActivity(intent);
    }

    public void deleteimg(View view) {
        Intent intent = new Intent(MainActivity.this, DeleteImage.class);
        startActivity(intent);
    }

    public void VIEW(View view) {
        Intent intent = new Intent(MainActivity.this, ViewImage.class);
        startActivity(intent);
    }

    public void RANGE(View view) {
        Intent intent = new Intent(MainActivity.this, Range.class);
        startActivity(intent);
    }
}
