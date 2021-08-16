package com.example.android3lesson2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Response;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {

    private ArrayList<Response> films = new ArrayList<>();

    public void setList(List<Response> list) {
        films.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(Response r){
        films.add(r);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item, parent, false);
        return new DetailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DetailViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
