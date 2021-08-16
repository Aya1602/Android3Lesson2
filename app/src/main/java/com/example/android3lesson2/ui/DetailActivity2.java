package com.example.android3lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.models.Response;
import com.example.android3lesson2.data.remote.RetrofitStorage;

import java.util.List;

public class DetailActivity2 extends AppCompatActivity {

    DetailAdapter adapter;
    RecyclerView recyclerView;

    public static final String ACTION = "ACTION";
    public static final String URL = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        recyclerView = findViewById(R.id.detail_recycler);
        adapter = new DetailAdapter();
        recyclerView.setAdapter(adapter);

        int action = getIntent().getIntExtra(ACTION,-1);
        String url = getIntent().getStringExtra(URL);

        switch (action){
            case 1:
                new RetrofitStorage().getPeoples(url, new RetrofitStorage.MyCallback<List<Response>>() {
                    @Override
                    public void success(List<Response> responses) {
                        adapter.setList(responses);
                    }

                    @Override
                    public void failure(String msg) {

                    }
                });
            case 2:
                new RetrofitStorage().getLocations(url, new RetrofitStorage.MyCallback<List<Response>>() {
                    @Override
                    public void success(List<Response> responses) {
                        adapter.setList(responses);
                    }

                    @Override
                    public void failure(String msg) {

                    }
                });
            case 3:
                new RetrofitStorage().getSpecies(url, new RetrofitStorage.MyCallback<Response>() {
                    @Override
                    public void success(Response response) {
                        adapter.addItem(response);
                    }

                    @Override
                    public void failure(String msg) {

                    }
                });
        }
    }
}