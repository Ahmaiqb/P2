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

public class shopping extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;


    GridView gridView;

    String[] names = {
            "Bilka", "Føtex", "Home & Harmony",
            "IKEA", "ILVA", "Jysk", "Netto", "Home Depot"

    };

    int[] images = {
            R.drawable.bilka, R.drawable.fotexstores, R.drawable.homeharmony,
            R.drawable.ikea, R.drawable.ilva, R.drawable.jysk,
            R.drawable.netto, R.drawable.thehomedepot
    };

    String[] descriptions = {
            "Bilka", "Føtex", "Home & Harmony",
            "IKEA", "ILVA", "Jysk", "Netto", "Home Depot"
    };

    String[] url = {
            "https://www.bilka.dk/", "https://www.foetex.dk/", "https://homes-harmony.com/",
            "https://www.ikea.com/", "http://www.ilva.dk", "https://www.jysk.com/", "https://netto.dk/", "https://www.homedepot.com/"
    };

    String[] maps = {
            //Bilka
            "https://www.google.dk/maps/search/bilka/@55.6605086,12.5617337,13z/data=!3m1!4b1",
            //Føtex
            "https://www.google.dk/maps/search/f%C3%B8tex/@55.6605955,12.5617337,13z/data=!3m1!4b1",
            //Home & Harmony
            "https://www.google.dk/maps/place/Living+In+Harmony/@55.6775092,12.3894285,17z/data=!3m1!4b1!4m5!3m4!1s0x465250c8a41421bb:0xaa01fe17621c7213!8m2!3d55.6775062!4d12.3916172",
            //IKEA
            "https://www.google.dk/maps/search/ikea/@55.6775556,12.3565979,13z/data=!3m1!4b1",
            //ILVA
            "https://www.google.dk/maps/search/ilva/@55.6776424,12.3565979,13z/data=!3m1!4b1",
            //Jysk
            "https://www.google.dk/maps/search/jysk/@55.6777293,12.3565979,13z/data=!3m1!4b1",
            //Netto
            "https://www.google.dk/maps/search/Netto/@55.6718146,12.4894638,13z",
            //Home Depot
            "https://www.google.dk/maps/search/Home+depot/@55.6719015,12.4894638,13z/data=!3m1!4b1"

    };

    String[] discount = {
            "Bilka", "Føtex", "Home & Harmony",
            "IKEA", "ILVA", "Jysk", "Netto", "Home Depot"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        shopping.CustomAdapter customAdapter = new shopping.CustomAdapter(names, images, this);

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



                startActivity(new Intent(shopping.this, ClickedItemActivity.class)
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