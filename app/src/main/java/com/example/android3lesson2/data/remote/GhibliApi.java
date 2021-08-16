package com.example.android3lesson2.data.remote;

import com.example.android3lesson2.data.models.Film;
import com.example.android3lesson2.data.models.Location;
import com.example.android3lesson2.data.models.People;
import com.example.android3lesson2.data.models.Response;
import com.example.android3lesson2.data.models.Species;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GhibliApi {
    @GET("/films/{id}")
    Call<Film> getFilm(
            @Path("id") String id
    );

    @GET("films")
    Call<List<Film>> getFilms();

    @GET
    Call<List<Response>> getPeoples(@Url String url);

    @GET
    Call<List<Response>> getLocations(@Url String url);

    @GET
    Call<Response> getSpecies(@Url String url);

    @POST("/createFilm")
    Call<ResponseBody> createFilm(
            @Body Film film
    );
}
