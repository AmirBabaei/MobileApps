package com.example.lab3;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class download extends AppCompatActivity {


    static TextView getUrl;
    static ImageView imageView;

    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        getUrl = findViewById(R.id.geturl);
        imageView = findViewById(R.id.imageView);

        //download image
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
    }


    public void downloadImage(View view) {
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            ImageDownloader imageDownloader = new ImageDownloader();
            imageDownloader.execute(getUrl.getText().toString());
        }
        else{
            Toast.makeText(download.this, "NO INTERNET CONNECTION", Toast.LENGTH_LONG).show();
        }
    }

}
