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

public class restaurant extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    ImageButton search;

    GridView gridView;

    String[] names = {
            "Burger King", "Domino's Pizza", "Dunkin' Donuts",
            "MCD", "Molino Pizza", "Teté", "KFC", "YO! Sushi"
    };

    int[] images = {
            R.drawable.burgerking, R.drawable.dominospizza, R.drawable.dunkindonuts,
            R.drawable.mcdonalds, R.drawable.molinorestaurants, R.drawable.teterestaurant,
            R.drawable.kfc, R.drawable.yosushi
    };

    String[] descriptions = {
            "Burger King", "Domino's Pizza", "Dunkin' Donuts",
            "MCD", "Molino Pizza", "Teté", "\"KFC kom til Danmark i 70'erne, hvor de åbnede deres\\n\" +\n" +
            "                    \"første restaurant i Rødovre. I dag har KFC 6 restauranter\\n\" +\n" +
            "                    \"i Storkøbenhavn, 2 i Odense, 1 i Herning og 1 i Tilst.\\n\" +\n" +
            "                    \"\\n\" +\n" +
            "                    \"Så hvis du er sulten efter noget lækkert kylling, så tag et\\n\" +\n" +
            "                    \"kig på deres hjemmeside og bestil med 15% rabat.\\n\" +\n" +
            "                    \"\\n\" +\n" +
            "                    \" Placeringer:\\n\" +\n" +
            "                    \"   - Online Bestilling\\n\" +\n" +
            "                    \"   - Rådhuspladsen 55, 1550 København V\",", "YO! Sushi"
    };

    String[] url = {
            "https://www.bk.com/", "https://www.dominos.com/index.intl.html", "https://wolt.com/da/dnk/roskilde/restaurant/dunkin-donuts",
            "https://www.mcdonalds.com/", "https://molinositaliankitchen.com/", "https://www.teterestaurant.ae/", "https://kfc.dk/", "https://yosushi.com/"
    };

    String[] maps = {
            "https://www.google.dk/maps/search/burger+king/@55.6719883,12.4894638,13z/data=!3m1!4b1",
            "https://www.google.dk/maps/search/domino's+pizza/@55.6720751,12.4894638,13z/data=!3m1!4b1",
            "https://www.google.dk/maps/place/Dunkin'/@55.6726776,12.563356,17z/data=!3m1!4b1!4m5!3m4!1s0x4652530d1590045b:0xda7b41e5ecf5a8e7!8m2!3d55.6726746!4d12.5655447",
            "https://www.google.dk/maps/search/mcdonald's/@55.6809105,12.5635813,12z/data=!3m1!4b1",
            "https://www.google.dk/maps/search/molinos+pizza/@55.7155917,12.5014201,12z",
            "https://www.google.dk/maps/search/tet%C3%A9/@55.7157452,12.50142,12z/data=!3m1!4b1",
            "https://www.google.dk/maps/search/kfc/@55.6666493,12.3661508,11z",
            "https://www.google.dk/maps/place/YO!+Sushi/@55.6282945,12.6466089,17z/data=!3m2!4b1!5s0x4653ab6fc2e10d0b:0x55f0c5880f36be4b!4m5!3m4!1s0x4653ab3d9c7f4f25:0x254835f3e4056769!8m2!3d55.6282915!4d12.6487976"
    };

    String[] discount = {
            "30%", "20%", "10%",
            "15%", "5%", "20%", "25%", "10%"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        restaurant.CustomAdapter customAdapter = new restaurant.CustomAdapter(names, images, this);

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

                startActivity(new Intent(restaurant.this, ClickedItemActivity.class)
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