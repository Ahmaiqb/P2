package com.example.studizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;

import java.net.URI;

public class ClickedItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView descriptiontxt;

    Button discount;
    String disurl = "https://kfc.dk/";


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
    }
}