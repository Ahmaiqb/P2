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

public class fashion extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    GridView gridView;

    String[] names = {
            "Asics", "Calvin Klein", "Diesel",
            "Fila", "Mango", "Nike", "Zara", "H&M"
    };

    int[] images = {
            R.drawable.asics, R.drawable.calvinklein, R.drawable.diesel,
            R.drawable.fila, R.drawable.mango, R.drawable.nike,
            R.drawable.zara, R.drawable.hm
    };

    String[] descriptions = {
            "Asics", "Calvin Klein", "Diesel",
            "Fila", "Mango", "Nike", "Zara", "H&M"
    };

    String[] url = {
            //Asics
            "https://www.asics.com",
            //Calvin Klein
            "https://www.calvinklein.dk",
            //Diesel
            "https://dk.diesel.com/en/",
            //Fila
            "https://www.fila.de",
            //mango
            "https://shop.mango.com/dk",
            //nike
            "https://www.nike.com/dk/",
            //Zara
            "https://www.zara.com/dk/",
            //hm
            "https://www2.hm.com/da_dk/index.html"
    };

    String[] maps = {
            //asics
            "https://www.google.dk/maps/dir//Asics,+Møinichen+Mansion,+Købmagergade+37,+1150+København/@55.7064325,12.5228636,12z/data=!4m17!1m7!3m6!1s0x0:0x3d98452c3af32fd0!2sAsics!8m2!3d55.6806461!4d12.5775305!15sCgVhc2ljcyIDiAEBWg4KBWFzaWNzIgVhc2ljc5IBFHNwb3J0aW5nX2dvb2RzX3N0b3Jl!4m8!1m0!1m5!1m1!1s0x4652531097f58e87:0x3d98452c3af32fd0!2m2!1d12.5775305!2d55.6806461!3e3",
            //calvin klein
            "https://www.google.dk/maps/dir//Calvin+Klein,+Kongens+Nytorv+13,+1050+København/@55.6793055,12.5812648,17z/data=!4m16!1m6!3m5!1s0x46525317a01eca63:0xbf1af19148698b73!2sCalvin+Klein!8m2!3d55.6792949!4d12.5832428!4m8!1m0!1m5!1m1!1s0x46525317a01eca63:0xbf1af19148698b73!2m2!1d12.5832428!2d55.6792949!3e3",
            //diesel
            "https://www.google.dk/maps/dir//DIESEL+STORE+COPENHAGEN+OSTERGADE,+12-14,+Østergade,+1100+København/@55.6793115,12.581254,17z/data=!3m1!5s0x4652531783db5acd:0xf684c4017880bb4b!4m17!1m7!3m6!1s0x4652533c77e7141d:0x6fdd1a2162a2163b!2sDIESEL+STORE+COPENHAGEN+OSTERGADE!8m2!3d55.680214!4d12.5840289!15sCgZkaWVzZWwiA4gBAVoQCgZkaWVzZWwiBmRpZXNlbJIBDmNsb3RoaW5nX3N0b3Jl!4m8!1m0!1m5!1m1!1s0x4652533c77e7141d:0x6fdd1a2162a2163b!2m2!1d12.5840289!2d55.680214!3e3",
            //fila
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //mango
            "https://www.google.dk/maps/dir//MANGO,+Østergade,+København/@55.6797228,12.5118667,12z/data=!3m1!4b1!4m9!4m8!1m0!1m5!1m1!1s0x46525351bf4770f7:0xcd4f02960de1d1a4!2m2!1d12.5820776!2d55.679646!3e3",
            //nike
            "https://www.google.dk/maps/dir//Nike+Factory+Store,+Herlev+Hovedgade,+Herlev/@55.7186408,12.3814848,12z/data=!3m1!4b1!4m9!4m8!1m0!1m5!1m1!1s0x465251b040e799e3:0xe147dd6c5885b6bc!2m2!1d12.4516957!2d55.7185641!3e3",
            //zara
            "https://www.google.dk/maps/dir//ZARA,+Vimmelskaftet,+København/@55.6786879,12.5058419,12z/data=!3m2!4b1!5s0x46525317339fd057:0x43fbb14d568e0eef!4m9!4m8!1m0!1m5!1m1!1s0x465253111d5600f3:0x433240a198ff2c39!2m2!1d12.5756839!2d55.6788208!3e3",
            //hm
            "https://www.google.dk/maps/dir//H%26M,+Amagertorv+23,+1160+København/@55.6782567,12.5780379,17.75z/data=!4m17!1m7!3m6!1s0x0:0x5b5746b3e3f8cea5!2zSCZN!8m2!3d55.6784092!4d12.5775246!15sCgJobSIDiAEBWggKAmhtIgJobZIBDmNsb3RoaW5nX3N0b3Jl!4m8!1m0!1m5!1m1!1s0x46525310df49fc87:0x5b5746b3e3f8cea5!2m2!1d12.5775246!2d55.6784092!3e3"
    };

    String[] discount = {
            "Asics", "Calvin Klein", "Diesel",
            "Fila", "Mango", "Nike", "Zara", "H&M"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        fashion.CustomAdapter customAdapter = new fashion.CustomAdapter(names, images, this);

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

                startActivity(new Intent(fashion.this, ClickedItemActivity.class)
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