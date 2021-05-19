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

public class books extends AppCompatActivity {
    ImageButton home;
    ImageButton studiekort;
    ImageButton settings;
    ImageButton kategorier;

    GridView gridView;

    String[] names = {
            "Arnold Busck", "IDG Books", "Saxo",
            "Study Express", "Warner Books", "Academic Books",

    };

    int[] images = {
            R.drawable.arnoldbusck, R.drawable.idgbooksworldwide, R.drawable.saxo,
            R.drawable.studyexpress, R.drawable.warnerbooks, R.drawable.academicbooks,
    };

    String[] descriptions = {
            "Arnold Busck", "IDG Books", "Saxo",
            "Study Express", "Warner Books", "Academic Books",
    };

    String[] url = {
            //arnold busck, ingen hjemmeside?
            "http://www.boghandlereidanmark.dk/index.php?id=967&beskrivelsesnummer=103&p_mode=beskrivelse&cHash=d95ce511a7e598fc1dcdf47d57a02aab",
            //IDG Books
            "https://www.idgkurser.dk/?gclid=CjwKCAjwy42FBhB2EiwAJY0yQnspDjrHxwu-YRMei5lVIMYM8GNCiR3c7OyGkebr6qlZNGM17Y-7ERoCb80QAvD_BwE",
            //Saxo
            "https://www.saxo.com/dk/",
            //study express
            "https://studyexpress.com.pk",
            //Warner books
            "https://www.saxo.com/dk/forlag/warner-books_107154?page=1",
            //academic books
            "https://www.academicbooks.dk",
    };

    String[] maps = {
            //arnold busck
            "https://www.google.dk/maps/dir//Arnold+Busck,+Købmagergade+49,+1150+København/@55.6811179,12.5737772,17z/data=!3m1!5s0x4652531086e08dd7:0xfea10548b47988af!4m16!1m6!3m5!1s0x4652531080b3096d:0xb96cb24ac6f55f90!2sArnold+Busck!8m2!3d55.6811149!4d12.5759712!4m8!1m0!1m5!1m1!1s0x4652531080b3096d:0xb96cb24ac6f55f90!2m2!1d12.5759712!2d55.6811149!3e3",
            //idg books
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //saxo
            "https://www.google.dk/maps/dir//Saxo.Com+A%2FS,+Østerbrogade+200,+2100+København/@55.7063329,12.5756079,14z/data=!4m17!1m7!3m6!1s0x465252f4780f82f3:0xd7fad45ca051c647!2sSaxo.Com+A%2FS!8m2!3d55.7116959!4d12.5778056!15sCgRTQVhPWgwKBHNheG8iBHNheG-SAQpib29rX3N0b3Jl!4m8!1m0!1m5!1m1!1s0x465252f4780f82f3:0xd7fad45ca051c647!2m2!1d12.5778056!2d55.7116959!3e3",
            //study express
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //warner books
            "https://www.google.dk/maps/dir//ingen+lokation/@55.6754145,12.5109307,12z/data=!3m1!4b1!4m2!4m1!3e3",
            //academic books
            "https://www.google.dk/maps/dir//Academic+Books,+Nørre+Allé+20,+2200+København/@55.6849174,12.5682881,14z/data=!4m17!1m7!3m6!1s0x0:0x289fb4247c47c00e!2sAcademic+Books!8m2!3d55.694794!4d12.5616377!15sCg5hY2FkZW1pYyBib29rcyIDiAEBkgEKYm9va19zdG9yZQ!4m8!1m0!1m5!1m1!1s0x46525300255f6c2f:0x289fb4247c47c00e!2m2!1d12.5616377!2d55.694794!3e3",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        //Find my gridView.
        gridView = findViewById(R.id.gridView);

        //Link between my UI components and the data source.
        books.CustomAdapter customAdapter = new books.CustomAdapter(names, images, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedDescription = descriptions[position];
                String selectedUrl = url[position];
                String selectedMaps = maps[position];

                startActivity(new Intent(books.this, ClickedItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage).putExtra("description", selectedDescription).putExtra("url", selectedUrl).putExtra("maps", selectedMaps));
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