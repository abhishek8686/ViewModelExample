package com.hysterical.abhishek.androidviewmodel.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.hysterical.abhishek.androidviewmodel.api_interface.API;
import com.hysterical.abhishek.androidviewmodel.model.Hero;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesViewModel extends ViewModel {

    private MutableLiveData<List<Hero>> herolist;

    public LiveData<List<Hero>> getHeroes() {
        if (herolist == null) {
            herolist = new MutableLiveData<List<Hero>>();
            loadHeroes();
        }
        return herolist;
    }

    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        API api = retrofit.create(API.class);
        Call<List<Hero>> call = api.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                herolist.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }
}
