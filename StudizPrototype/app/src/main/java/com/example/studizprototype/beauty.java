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

public class beauty extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    GridView gridView;

    String[] names = {
            "Dove", "L'ORÉAL", "MAC",
            "Nivea", "NYX"

    };

    int[] images = {
            R.drawable.dove, R.drawable.loreal, R.drawable.maccosmetics,
            R.drawable.nivea, R.drawable.nyxcosmetics
    };

    String[] descriptions = {
            "Dove", "L'ORÉAL", "MAC",
            "Nivea", "NYX"
    };

    String[] url = {
            //dove
            "https://www.dove.com/dk/home.html?gclid=CjwKCAjwy42FBhB2EiwAJY0yQsliK_oYAyMhdoXk7zXNGCBZwp-ELSJb8fNY4EhVfzBuG8lISE0z0hoCt-sQAvD_BwE&gclsrc=aw.ds",
            //L'ORÉAL
            "https://www.lorealparis.dk",
            //MAC Cosmetics
            "https://www.maccosmetics.com",
            //Nivea
            "https://www.nivea.dk",
            //nyx
            "https://www.nyxcosmetics.com"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        beauty.CustomAdapter customAdapter = new beauty.CustomAdapter(names, images, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedDescription = descriptions[position];
                String selectedUrl = url[position];

                startActivity(new Intent(beauty.this, ClickedItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage).putExtra("description", selectedDescription).putExtra("url", selectedUrl));
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