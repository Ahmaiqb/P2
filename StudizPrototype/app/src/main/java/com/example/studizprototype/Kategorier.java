package com.example.studizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

public class Kategorier extends AppCompatActivity {

    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;

    GridView gridView;

    int[] images = {
            R.drawable.hm, R.drawable.adidas, R.drawable.adobe,
            R.drawable.airbnb, R.drawable.warnerbooks, R.drawable.bacardi,
            R.drawable.mcdonalds, R.drawable.academicbooks, R.drawable.apple,
            R.drawable.heineken, R.drawable.kfc, R.drawable.fotexstores
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorier);

        home = findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHome();
            }
        });

        studiekort = findViewById(R.id.studiekortBtn);
        studiekort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadStudiekort();
            }
        });

        settings = findViewById(R.id.settingsBtn);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSettings();
            }
        });

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int selectedImage = images[position];
                startActivity(new Intent(Kategorier.this, ClickedItemActivity.class).putExtra("image", selectedImage));

            }
        });
    }

    private void loadHome() {
        Intent kategori = new Intent(this,homepage1.class);
        startActivity(kategori);
    }

    private void loadStudiekort() {
        Intent studiekort = new Intent(this,Studiekort.class);
        startActivity(studiekort);
    }

    private void loadSettings() {
        Intent setting = new Intent(this,Settings.class);
        startActivity(setting);
    }
}