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

    public void goToit (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, it.class);
        startActivity(intent);
    }

    public void goTofreetime (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, freetime.class);
        startActivity(intent);
    }

    public void goToshopping (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, shopping.class);
        startActivity(intent);
    }

    public void goTofashion (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, fashion.class);
        startActivity(intent);
    }

    public void goTotransport (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, transport.class);
        startActivity(intent);
    }

    public void goTobeauty (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, beauty.class);
        startActivity(intent);
    }

    public void goTosport (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, sport.class);
        startActivity(intent);
    }

    public void goTohealth (View v){
        // Capture an image in response to button
        Intent intent = new Intent(this, health.class);
        startActivity(intent);
    }

}