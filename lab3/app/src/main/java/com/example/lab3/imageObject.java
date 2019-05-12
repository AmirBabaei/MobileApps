package com.example.lab3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;

public class imageObject {

    private String title;
    private byte[] bArray;
    public imageObject(String name, String description, byte[] bArray)
    {
        this.title = title;
        this.bArray = bArray;
    }

    public String getTitle() {
        return title;
    }

    public byte[] getByeArray() {
        return bArray;
    }
    public Bitmap getBmp(){
        ByteArrayInputStream imageStream = new ByteArrayInputStream(bArray);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        if (theImage != null) {
            return theImage;
        }
        else{
            return null;
        }
    }

}
