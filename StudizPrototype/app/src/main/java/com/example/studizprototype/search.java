package com.example.studizprototype;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AlphabetIndexer;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class search extends AppCompatActivity {

    private ListView lastSerch;
    private EditText editSearch;
    private ArrayAdapter<String> adapter;

    Button button;

    String data[] = {
            "Academic books", "Adidas", "Adobe",
            "Airbnb", "Apple", "Bacardi", "Føtex",
            "H&M", "Heineken", "KFC", "Mcdonald's","Warner books"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchfunction);

        lastSerch = (ListView) findViewById(R.id.lastSearch);
        editSearch = (EditText) findViewById(R.id.editSearch);
        adapter = new ArrayAdapter<String>(this, R.layout.listsearch,R.id.textView,data);
        lastSerch.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
