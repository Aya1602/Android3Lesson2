package com.example.android3lesson2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Film;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private ArrayList<Film> films = new ArrayList<>();
    private OnFilmClickListener listener;

    public FilmAdapter(OnFilmClickListener filmClickListener){
        listener = filmClickListener;
    }

    public void setFilms(List<Film> list){
        films.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item,parent,false);
        return new FilmViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FilmViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
