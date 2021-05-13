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

public class Kategorier extends AppCompatActivity {

    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;

    GridView gridView;

    String[] names = {
            "Barer & Diskoteker", "Bøger & Studie", "Cafeer & Restauranter",
            "Elektronik & IT", "Fritid & Fornøjelse", "Indretning & Dagligvare",
            "Mode", "Rejser & Transport", "Skønhed & Velvare",
            "Sport & Fitness", "Sundhed & Helse",
    };

    int[] images = {
            R.drawable.catbar, R.drawable.catbooks, R.drawable.catrestaurant,
            R.drawable.catelectronic, R.drawable.catfreetime, R.drawable.catshop,
            R.drawable.catfashion, R.drawable.cattransport, R.drawable.catbeauty,
            R.drawable.catsport, R.drawable.cathealt
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorier);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        Kategorier.CustomAdapter customAdapter = new Kategorier.CustomAdapter(names, images, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            int selectedImage = images[position];
            startActivity(new Intent(Kategorier.this, ClickedItemActivity.class).putExtra("image", selectedImage));
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
        Intent kategori = new Intent(this,homepage1.class);
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