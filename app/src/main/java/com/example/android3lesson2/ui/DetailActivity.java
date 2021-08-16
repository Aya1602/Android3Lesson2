package com.example.android3lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Film;
import com.example.android3lesson2.data.remote.RetrofitStorage;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView title,description,director,producer;
    Button people,species,location;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.desc_title);
        description = findViewById(R.id.desc_description);
        director = findViewById(R.id.desc_director);
        producer = findViewById(R.id.desc_producer);

        people = findViewById(R.id.btn_people);
        species = findViewById(R.id.btn_species);
        location = findViewById(R.id.btn_locations);

        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,DetailActivity2.class);
                intent.putExtra(DetailActivity2.ACTION,1);
                intent.putExtra(DetailActivity2.URL,film.getPeople().get(0));
                startActivity(intent);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,DetailActivity2.class);
                intent.putExtra(DetailActivity2.ACTION,2);
                intent.putExtra(DetailActivity2.URL,film.getLocations().get(0));
                startActivity(intent);
            }
        });

        species.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,DetailActivity2.class);
                intent.putExtra(DetailActivity2.ACTION,3);
                intent.putExtra(DetailActivity2.URL,film.getSpecies().get(0));
                startActivity(intent);
            }
        });

        String id = getIntent().getStringExtra(MainActivity.FILM_ID);

        new RetrofitStorage().getFilm(id, new RetrofitStorage.MyCallback<Film>() {
            @Override
            public void success(Film body) {
                film = body;
                title.setText(body.getTitle());
                description.setText(body.getDescription());
                director.setText(body.getDirector());
                producer.setText(body.getProducer());
            }

            @Override
            public void failure(String msg) {
                Log.d("Tag", msg);
            }
        });


    }
}