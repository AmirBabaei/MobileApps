package com.example.lab3;

import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;

public class download extends AppCompatActivity {


    //DBhandler db;



    // public static SQLiteOpenHelper sqLiteHelper;

    static TextView getUrl;
    static TextView title;
    static ImageView imageView;
    static byte[] byteImage;

    //static  Bitmap bmap;*/



    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);




        getUrl = findViewById(R.id.geturl);
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.gettitle);


        //download image
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();




    }




    public void downloadImage(View view) {
        Bitmap bmap;
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            ImageDownloader imageDownloader = new ImageDownloader();
            try {
                bmap = imageDownloader.execute(getUrl.getText().toString()).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainActivity.titlename = (title.getText().toString());
            finish();
            Toast.makeText(download.this, "DOWNLOAD SUCCESSFUL", Toast.LENGTH_LONG).show();


        }
        else{
            Toast.makeText(download.this, "ERROR", Toast.LENGTH_LONG).show();
        }
    }

}
