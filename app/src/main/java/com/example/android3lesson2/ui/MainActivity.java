package com.example.android3lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Film;
import com.example.android3lesson2.data.remote.RetrofitBuilder;
import com.example.android3lesson2.data.remote.RetrofitStorage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnFilmClickListener {

    FilmAdapter filmAdapter;
    RecyclerView filmRecycler;

    public static final String FILM_ID = "FILM_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmAdapter = new FilmAdapter(this);
        filmRecycler = findViewById(R.id.film_recycler);
        filmRecycler.setAdapter(filmAdapter);

        new RetrofitStorage().getFilms(new RetrofitStorage.MyCallback<List<Film>>() {
            @Override
            public void success(List<Film> body) {
                filmAdapter.setFilms(body);
            }

            @Override
            public void failure(String msg) {
                Log.d("Tag", msg);
            }
        });

    }

    @Override
    public void onClick(Film film) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(FILM_ID,film.getId());
        startActivity(intent);
    }
}