package com.example.android3lesson2.ui;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Film;

public class FilmViewHolder extends RecyclerView.ViewHolder {

    TextView title,description;
    Film film;

    public FilmViewHolder(View itemView,OnFilmClickListener filmClickListener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filmClickListener.onClick(film);
            }
        });
        title = itemView.findViewById(R.id.title_tv);
        description = itemView.findViewById(R.id.description_tv);
    }

    public void onBind(Film film){
        this.film = film;
        title.setText(film.getTitle());
        description.setText(film.getDescription());
    }

}
