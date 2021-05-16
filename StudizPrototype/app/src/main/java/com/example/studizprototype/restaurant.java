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
            //H&M
            "Bliv H&M Member og få rabat + fri standard levering på dit næste køb!" + '\n' + "Placeringer: Online shop",

            //Adidas
            "Sport holder os i form. Holder os vågne. Forener os." +
                    "\n" + "Sport har evnen til at ændre liv. Om det er gennem\n" + "historier om inspirerende atleter.\n" +
                    "Om det får dig ud af døren. \n" +
                    "Sportstøj med de seneste teknologier, der forbedrer din\n" +
                    "performance. Slå din personlige rekord. adidas er\n" +
                    "hjemmet for løbere, basketballspillere,\n" +
                    "fitness-entusiaster og fodboldfans i alle aldre" +
                    "\n" +
                    " Placeringer:\n" +
                    "   - Online Bestilling\n",
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

                startActivity(new Intent(restaurant.this, ClickedItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage).putExtra("description", selectedDescription));
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