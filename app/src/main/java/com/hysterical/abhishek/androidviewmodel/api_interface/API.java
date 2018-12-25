package com.hysterical.abhishek.androidviewmodel.api_interface;

import com.hysterical.abhishek.androidviewmodel.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
