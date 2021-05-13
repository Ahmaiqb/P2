package com.example.studizprototype;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class homepage1 extends AppCompatActivity {

    ImageButton kategorier;
    ImageButton studiekort;
    ImageButton settings;

    GridView gridView;

    String[] names = {
            "H&M", "adidas", "Adobe",
            "Airbnb", "Warner books", "Bacardi",
            "Mcdonald's", "Academic books", "Apple",
            "Heineken", "KFC", "Føtex"
    };

    int[] images = {
            R.drawable.hm, R.drawable.adidas, R.drawable.adobe,
            R.drawable.airbnb, R.drawable.warnerbooks, R.drawable.bacardi,
            R.drawable.mcdonalds, R.drawable.academicbooks, R.drawable.apple,
            R.drawable.heineken, R.drawable.kfc, R.drawable.fotexstores
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

            //Adobe
            "Kreativitet ligger i vores DNA. Vores skelsættende\n" +
                    "innovationer redefinerer mulighederne ved digitale\n" +
                    "oplevelser. Vi forbinder indhold og data og introducerer\n" +
                    "nye teknologier, der demokratiserer kreativitet, former\n" +
                    "næste generation af historiefortælling samt inspirerer\n" +
                    "til helt nye forretningskategorier."
                    +  "\n" +
                    " Placeringer:\n" +
                    "   - Online Bestilling\n",

            //Airbnb
            "Airbnb was born in 2007 when two Hosts welcomed\n" +
                    " three guests to their San Francisco home, and has since\n" +
                    " grown to 4 million Hosts who have welcomed over 800\n" +
                    " million guest arrivals in almost every country across the\n" +
                    " globe. Every day, Hosts offer one-of-a-kind stays and\n" +
                    " unique Experiences that make it possible for guests\n" +
                    " to experience the world in a more authentic, connected\n" +
                    " way."
                    +  "\n" +
                    " Placeringer:\n" +
                    "   - Online Bestilling\n",

            //Warner books
            "Warner books",

            //Bacardi
            "Bacardi",

            //McDonald's
            "McDonald's",

            //Academic books
            "I dag består Academic Books ikke kun af fysiske butikker\n" +
                    "på uddannelsesinstitutioner. Vi fungerer i særdeleshed\n" +
                    "også som en nonprofit online bogforretning,\n" +
                    "hvor du - ligesom altid - nemt og hurtigt kan købe dine\n" +
                    "\n" +
                    " Placeringer:\n" +
                    "   - Online Bestilling\n",


            //Apple
            "Hvorfor vælge Apple:\n" +
                    "   Apple's ambition er at være den \n" +
                    "   studerendes fortrukne valg, og har \n" +
                    "   tilpasset en lang række af sine \n" +
                    "   produkter til de studerendes særlig\n" +
                    "   behov og krav.\n" +
                    "Placeringer:\n" +
                    "   - Online Shop",

            //Heineken
            "Heineken",

            //KFC
            "KFC kom til Danmark i 70'erne, hvor de åbnede deres\n" +
                    "første restaurant i Rødovre. I dag har KFC 6 restauranter\n" +
                    "i Storkøbenhavn, 2 i Odense, 1 i Herning og 1 i Tilst.\n" +
                    "\n" +
                    "Så hvis du er sulten efter noget lækkert kylling, så tag et\n" +
                    "kig på deres hjemmeside og bestil med 15% rabat.\n" +
                    "\n" +
                    " Placeringer:\n" +
                    "   - Online Bestilling\n" +
                    "   - Rådhuspladsen 55, 1550 København V",

            //Føtex
            "Føtex"


    };


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage1);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        CustomAdapter customAdapter = new CustomAdapter(names, images, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedDescription = descriptions[position];

                startActivity(new Intent(homepage1.this, ClickedItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage).putExtra("description", selectedDescription));

            }
        });

        //ImageSlider
        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://i.imgur.com/eNivmRA.png", "Telsa"));
        slideModels.add(new SlideModel("https://i.imgur.com/FagLTq2.png", "Gucci"));
        slideModels.add(new SlideModel("https://i.imgur.com/IOFwVy1.png", "Amazon Prime Video"));
        imageSlider.setImageList(slideModels, true);

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

    private void loadKategori() {
        Intent kategori = new Intent(this,Kategorier.class);
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