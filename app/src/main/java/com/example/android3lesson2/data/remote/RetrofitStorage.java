package com.example.android3lesson2.data.remote;

import com.example.android3lesson2.data.models.Film;
import com.example.android3lesson2.data.models.Location;
import com.example.android3lesson2.data.models.People;
import com.example.android3lesson2.data.models.Species;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitStorage {

    public void getFilm(String id, MyCallback<Film> callback){
        RetrofitBuilder.getInstance().getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }else {
                    callback.failure("Error");
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                callback.failure(t.getLocalizedMessage());
            }
        });
    }

    public void getFilms(MyCallback<List<Film>> callback){
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }else {
                    callback.failure("Error");
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                callback.failure(t.getLocalizedMessage());
            }
        });
    }

    public void getPeoples(String url,MyCallback<List<com.example.android3lesson2.data.models.Response>> callback){
        RetrofitBuilder.getInstance().getPeoples(url).enqueue(new Callback<List<com.example.android3lesson2.data.models.Response>>() {
            @Override
            public void onResponse(Call<List<com.example.android3lesson2.data.models.Response>> call, Response<List<com.example.android3lesson2.data.models.Response>> response) {
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<com.example.android3lesson2.data.models.Response>> call, Throwable t) {

            }
        });
    }

    public void getLocations(String url,MyCallback<List<com.example.android3lesson2.data.models.Response>> callback){
        RetrofitBuilder.getInstance().getLocations(url).enqueue(new Callback<List<com.example.android3lesson2.data.models.Response>>() {
            @Override
            public void onResponse(Call<List<com.example.android3lesson2.data.models.Response>> call, Response<List<com.example.android3lesson2.data.models.Response>> response) {
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<com.example.android3lesson2.data.models.Response>> call, Throwable t) {

            }
        });
    }

    public void getSpecies(String url,MyCallback<com.example.android3lesson2.data.models.Response> callback){
        RetrofitBuilder.getInstance().getSpecies(url).enqueue(new Callback<com.example.android3lesson2.data.models.Response>() {
            @Override
            public void onResponse(Call<com.example.android3lesson2.data.models.Response> call, Response<com.example.android3lesson2.data.models.Response> response) {
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<com.example.android3lesson2.data.models.Response> call, Throwable t) {

            }
        });
    }

    public interface MyCallback<ResponseBody> {
        void success(ResponseBody body);
        void failure(String msg);
    }
}
