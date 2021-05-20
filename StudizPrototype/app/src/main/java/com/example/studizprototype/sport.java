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

public class sport extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    ImageButton search;

    GridView gridView;

    String[] names = {
            "Asics", "Fila", "Nike",
            "Adidas", "Lifetime Fitness", "Fitbit"
    };

    int[] images = {
            R.drawable.asics, R.drawable.fila, R.drawable.nike,
            R.drawable.adidas, R.drawable.lifetimefitness, R.drawable.fitbit
    };

    String[] descriptions = {
            "Asics", "Fila", "Nike",
            "Adidas", "Lifetime Fitness", "Fitbit"
    };

    String[] url = {
            "https://www.asics.com/us/en-us/", "https://www.fila.de/", "https://www.nike.com/dk/en/",
            "https://www.adidas-group.com/en/", "https://shop.lifetime.life/", "https://www.fitbit.com/global/dk/home"
    };

    String[] maps = {
            //Asics
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //Fila
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //Nike
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //Adidas
            "https://www.google.com/maps/dir//Pilestr%C3%A6de+8B++1112+K%C3%B8benhavn+K/@55.6604133,12.5617215,14z/data=!4m2!4m1!3e1",
            //Lifetime Fitness
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //Fitbit
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3"
    };

    String[] discount = {
            "10%", "20%", "15%",
            "10%", "50%", "25%"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        sport.CustomAdapter customAdapter = new sport.CustomAdapter(names, images, this);

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

                startActivity(new Intent(sport.this, ClickedItemActivity.class)
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

        search = findViewById(R.id.searchBtn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSearch();
            }
        });
    }

    private void loadSearch() {
        Intent searchIntent = new Intent(this,search.class);
        startActivity(searchIntent);
    }
    //Bottom menu button functions
    private void loadHome() {
        Intent home = new Intent(this,homepage1.class);
        startActivity(home);
    }

    private void loadStudiekort() {
        Intent studiekort = new Intent(this,Studiekort.class);
        startActivity(studiekort);
    }

    private void loadKategori() {
        Intent kategori = new Intent(this,categories.class);
        startActivity(kategori);
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