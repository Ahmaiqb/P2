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

    String[] maps = {
            //dove
            "https://www.google.dk/maps/",
            //loreal
            "https://www.google.dk/maps/dir//L'Oréal+Danmark,+Havneholmen+25,+1561+København/@55.6613654,12.5613419,17z/data=!4m16!1m6!3m5!1s0x4652573226cfe82f:0xf34f55d28ef0faca!2sL'Oréal+Danmark!8m2!3d55.6613624!4d12.5635359!4m8!1m0!1m5!1m1!1s0x4652573226cfe82f:0xf34f55d28ef0faca!2m2!1d12.5635359!2d55.6613624!3e3",
            //MAC
            "https://www.google.dk/maps/dir//MAC+Cosmetics,+Kongens+Nytorv+13,+1050+København/@55.6801509,12.5817051,17z/data=!3m1!5s0x46525317a25ae95b:0xc6815eaa06fe51c!4m17!1m7!3m6!1s0x0:0x3210dc8edddd714e!2sMAC+Cosmetics!8m2!3d55.6791605!4d12.5832215!15sCg1tYWMgY29zbWV0aWNzIgOIAQGSAQ9jb3NtZXRpY3Nfc3RvcmU!4m8!1m0!1m5!1m1!1s0x465253170a8823fd:0x3210dc8edddd714e!2m2!1d12.5832215!2d55.6791605!3e3",
            //nivea
            "https://www.google.dk/maps/",
            //NYX
            "https://www.google.dk/maps/"
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
                String selectedMaps = maps[position];

                startActivity(new Intent(beauty.this, ClickedItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage).putExtra("description", selectedDescription).putExtra("url", selectedUrl).putExtra("maps", selectedMaps));
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