package com.example.studizprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class toolbar extends homepage1 {

    ImageButton search;

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

    }

    private void loadSearch() {
        Intent Search = new Intent(this,search.class);
        startActivity(Search);
    }
}
