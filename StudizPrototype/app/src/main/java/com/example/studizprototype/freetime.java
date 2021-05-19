package com.example.studizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class freetime extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    GridView gridView;

    String[] names = {
            "AMF", "Film Casino", "Imax",
            "Monthly Fishing Magazines", "Netflix", "Skyzone"
    };

    int[] images = {
            R.drawable.bowling, R.drawable.filmcasino, R.drawable.imaxtheatre,
            R.drawable.monthlyfishingmagazines, R.drawable.netflix, R.drawable.skyzone,
    };

    String[] descriptions = {
            "AMF", "Film Casino", "Imax",
            "Monthly Fishing Magazines", "Netflix", "Skyzone"
    };

    String[] url = {

            //AMF
            "https://www.amf.com",
            //film casino
            "https://www.casino.dk",
            //Tmax
            "cinemaxx.dk/",
            //Monthly fishing magazine
            "http://fishingmonthly.com.au",
            //netflix
            "www.netflix.com/",
            //skyzone
            "https://www.skyzone.com"
    };

    String[] maps = {
            //amf
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //film casino
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //IMAX
            "https://www.google.dk/maps/dir//CinemaxX,+Kalvebod+Brygge,+København/@55.6627257,12.4925712,12z/data=!3m2!4b1!5s0x46525317339fd057:0x43fbb14d568e0eef!4m9!4m8!1m0!1m5!1m1!1s0x465253702c776715:0xc83b4c761e13204d!2m2!1d12.5627821!2d55.6626489!3e3",
            //monthly fishing
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //netflix
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //skyzone
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3"
    };

    String[] discount = {
            "AMF", "Film Casino", "Imax",
            "Monthly Fishing Magazines", "Netflix", "Skyzone"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freetime);
        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        freetime.CustomAdapter customAdapter = new freetime.CustomAdapter(names, images, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedDescription = descriptions[position];
                String selectedUrl = url[position];
                String selectedMaps = maps[position];
                String selecteddc = discount[position];

                startActivity(new Intent(freetime.this, ClickedItemActivity.class)
                        .putExtra("name", selectedName)
                        .putExtra("image", selectedImage)
                        .putExtra("description", selectedDescription)
                        .putExtra("url", selectedUrl)
                        .putExtra("maps", selectedMaps)
                        .putExtra("discount", selecteddc));
            }
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

    public class CustomAdapter extends BaseAdapter {
        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            if(view == null) {
                view = layoutInflater.inflate(R.layout.row_items, viewGroup,false);
            }

            //Find my text and image.
            TextView tvName = view.findViewById(R.id.tvName);
            ImageView imageView = view.findViewById(R.id.imageView);

            //Set my text and image.
            tvName.setText(imageNames[position]);
            imageView.setImageResource(imagesPhoto[position]);


            return view;
        }
    }
}