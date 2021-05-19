package com.example.studizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class toolbar extends homepage1 {

    ImageButton search;
    ImageButton map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);

        search = findViewById(R.id.searchIcon);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSearch();
            }
        });

        map = findViewById(R.id.kortIcon);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMap();
            }
        });

    }

    private void loadSearch() {
        Intent Search = new Intent(this,search.class);
        startActivity(Search);
    }

    private void loadMap() {
        Intent Map = new Intent(this,homepage1.class);
        startActivity(Map);
    }

}
