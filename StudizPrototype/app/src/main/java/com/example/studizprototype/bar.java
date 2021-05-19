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

public class bar extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    GridView gridView;

    String[] names = {
            "Amstel", "Bacardi", "Baileys", "Captain Morgan", "Heineken", "Jagermeister", "TGI Friday"
    };

    int[] images = {
            R.drawable.amstel, R.drawable.bacardi, R.drawable.baileys,
            R.drawable.captainmorgan, R.drawable.heineken, R.drawable.jagermeister,
            R.drawable.tgifridays
    };

    String[] descriptions = {
            "Amstel", "Bacardi", "Baileys", "Captain Morgan", "Heineken", "Jagermeister", "TGI Friday"
    };

    String[] url = {
            "https://www.amstel.com/", "https://www.bacardi.com/us/en/", "https://www.baileys.com/en-us/", "https://www.captainmorgan.com/en-us/products/",
            "https://www.heineken.com/dk/da/agegateway?returnurl=%2fglobal%2fen%2fhome", "https://www.jagermeister.com/en-US/", "https://www.tgifridays.com/"
    };

    String[] maps = {
            //amstel
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //bacardi
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //baileys
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //cap morgan
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //heineken
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //jagermeister
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //tgi friday
            "https://www.google.dk/maps/dir//TGI+Fridays+Copenhagen,+Højbro+Pl.+5,+1200+København/@55.6793831,12.5768932,16z/data=!3m1!5s0x4652531724345eab:0x199885380bcb9a33!4m16!1m6!3m5!1s0x4652531725c4e37f:0x31564a9b3216749b!2sTGI+Fridays+Copenhagen!8m2!3d55.6786572!4d12.5800903!4m8!1m0!1m5!1m1!1s0x4652531725c4e37f:0x31564a9b3216749b!2m2!1d12.5800903!2d55.6786572!3e3"
    };

    String[] discount = {
            "20%", "15%", "10%", "20%", "15%", "20%", "10%"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        bar.CustomAdapter customAdapter = new bar.CustomAdapter(names, images, this);

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

                startActivity(new Intent(bar.this, ClickedItemActivity.class)
                        .putExtra("name", selectedName).putExtra("image", selectedImage)
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