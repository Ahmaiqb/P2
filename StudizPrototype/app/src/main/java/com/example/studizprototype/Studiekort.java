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

    ImageButton search;

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

            search = findViewById(R.id.searchBtn);
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadSearch();
                }
            });
        }

    private void loadSearch() {
        Intent searchIntent = new Intent(this,search.class);
        startActivity(searchIntent);
    }

    private void loadHome() {
            Intent home = new Intent(this,homepage1.class);
            startActivity(home);
        }

        private void loadKategori() {
            Intent kategori = new Intent(this,categories.class);
            startActivity(kategori);
        }

        private void loadSettings() {
            Intent setting = new Intent(this,Settings.class);
            startActivity(setting);
        }
    }