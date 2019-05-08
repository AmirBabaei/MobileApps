package com.example.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
