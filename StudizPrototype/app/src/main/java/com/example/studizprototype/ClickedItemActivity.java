package com.example.studizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;

import java.net.URI;

public class ClickedItemActivity extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    ImageView imageView;
    TextView textView;
    TextView descriptiontxt;

    Button discount;
    String disurl = "https://kfc.dk/";

    Button maps;
    String mapsurl = "https://www.google.dk/maps/place/R%C3%A5dhuspladsen+55,+1550+K%C3%B8benhavn/@55.676448,12.5674966,17z/data=!3m1!4b1!4m5!3m4!1s0x4652531201b542c7:0x32d050afb5bb0788!8m2!3d55.676448!4d12.5696853";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        //Find my image and text.
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.tvName);
        descriptiontxt = findViewById(R.id.descriptiontext);

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image", 0);
            String selectedDescription = intent.getStringExtra("description");

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);
            descriptiontxt.setText(selectedDescription);
        }


        discount = findViewById(R.id.buttondiscount);
        discount.setOnClickListener((v) -> {

            Intent discPage = new Intent(Intent.ACTION_VIEW);
            discPage.setData(Uri.parse(disurl));
            startActivity(discPage);
        });

        maps = findViewById(R.id.buttonmaps);
        maps.setOnClickListener((v) -> {

            Intent mapsPage = new Intent(Intent.ACTION_VIEW);
            mapsPage.setData(Uri.parse(mapsurl));
            startActivity(mapsPage);
        });

        //Bottom menu buttons start here
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
    }
    //Bottom menu button functions
    private void loadHome() {
        Intent home = new Intent(this,homepage1.class);
        startActivity(home);
    }

    private void loadKategori() {
        Intent kategori = new Intent(this,categories.class);
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