package com.example.studizprototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AlphabetIndexer;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class search extends AppCompatActivity {

    private ListView lastSerch;
    private EditText editSearch;
    private ArrayAdapter<String> adapter;

    Button button;

    String data[] = {
            "AMF","Academic Books","Adidas","Alienware","Amstel","Apotek","Apple","Arnold Busck",
            "Asics","Asics","Bacardi","Baileys","Bilka","Burger King","Calvin Klein",
            "Captain Morgan","Computer City","Computer World","DELL","DSB","Diesel","Domino's Pizza"
            ,"Dove","Dunkin' Donuts","Fila","Fila","Film Casino","Fitbit","Føtex","H&M","HP",
            "Hastings Hotel","Heineken","Hello Fresh","Hilton","Home & Harmony","Home Depot",
            "IDG Books","IKEA","ILVA","Imax","Jagermeister","Jysk","KFC","L'ORÉAL",
            "Lifetime Fitness","MAC","MCD","Mango","Microsoft","Molino Pizza",
            "Monthly Fishing Magazines","NYX","Natural Health","Netflix","Netto","Nike","Nike",
            "Nivea","SAS","SKY Travel","Saxo","Skyzone","Study Express","TGI Friday","Teté",
            "Warner Books","XBOX","YO! Sushi","Zara"
    };

    String names[] = {
            "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple",
            "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple",
            "Apple", "Apple"
    };

    int[] images = {
            R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,
            R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,
            R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,
            R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,
    };

    String[] descriptions = {
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",
    };

    String[] url = {
            //apple
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/", "https://www.apple.com/dk/", "https://www.apple.com/dk/",
            "https://www.apple.com/dk/"

    };

    String[] maps = {
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3"
    };

    String[] discount = {
           "25%", "25%", "25%","25%","25%", "25%", "25%", "25%", "25%", "25%", "25%", "25%", "25%",
            "25%", "25%", "25%", "25%", "25%", "25%", "25%"
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

        lastSerch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedDescription = descriptions[position];
                String selectedUrl = url[position];
                String selectedMaps = maps[position];
                String selecteddc = discount[position];

                startActivity(new Intent(search.this, ClickedItemActivity.class)
                        .putExtra("name", selectedName)
                        .putExtra("image", selectedImage)
                        .putExtra("description", selectedDescription)
                        .putExtra("url", selectedUrl)
                        .putExtra("maps", selectedMaps)
                        .putExtra("discount", selecteddc));
            }
        });

    }
}