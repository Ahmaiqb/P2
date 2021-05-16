package com.example.studizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class categories extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    public void goTobar (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, bar.class);
        startActivity(intent);
    }

    public void goTobooks (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, books.class);
        startActivity(intent);
    }

    public void goTorestaurant (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, restaurant.class);
        startActivity(intent);
    }

}