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

    static TextView getUrl;
    //static TextView title;
    static String titlename;
    static ImageView imageView;

    public static DBhandler db;
    public static Bitmap bmap;

    static boolean bool = false;


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

        db = new DBhandler(this, "IMAGE_GALLERY", null, 1);

    }


    public static void insertIntoDb()
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmap.compress(Bitmap.CompressFormat.JPEG, 10, stream);
        byte[] bArray = stream.toByteArray();
        db.insert(titlename, bArray);
        bmap.recycle();
        bool =true;
    }

    public void download(View view) {
        Intent intent = new Intent(MainActivity.this, download.class);
        startActivity(intent);
    }

    public void delete(View view) {
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
