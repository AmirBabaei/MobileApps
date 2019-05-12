package com.example.lab3;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteImage extends AppCompatActivity {

    TextView byid;
    TextView bytitle;

    String id;
    String title;
    DBhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_image);


        byid = findViewById(R.id.byid);
        bytitle = findViewById(R.id.bytitle);
        db = MainActivity.db;

    }

    public void deleteimage(View view){
        id = byid.getText().toString();
        title = bytitle.getText().toString();
        db.delete(id, title);
        finish();

    }

}
