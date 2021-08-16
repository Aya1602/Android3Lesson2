package com.example.android3lesson2.ui;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Film;
import com.example.android3lesson2.data.models.Response;

public class DetailViewHolder extends RecyclerView.ViewHolder {

    TextView title, description;

    public DetailViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_tv);
        description = itemView.findViewById(R.id.description_tv);
    }

    public void onBind(Response response) {
        title.setText(response.getTitle());
    }

}
