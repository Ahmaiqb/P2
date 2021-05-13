package com.example.studizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Studiekort extends AppCompatActivity {

    ImageButton home;
    ImageButton kategorier;
    ImageButton settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studiekort);

            home = findViewById(R.id.homeBtn);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadHome();
                }
            });

            kategorier = findViewById(R.id.kategoriBtn);
            kategorier.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadKategori();
                }
            });

            settings = findViewById(R.id.settingsBtn);
            settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadSettings();
                }
            });
        }

        private void loadHome() {
            Intent kategori = new Intent(this,homepage1.class);
            startActivity(kategori);
        }

        private void loadKategori() {
            Intent studiekort = new Intent(this,Kategorier.class);
            startActivity(studiekort);
        }

        private void loadSettings() {
            Intent setting = new Intent(this,Settings.class);
            startActivity(setting);
        }
    }