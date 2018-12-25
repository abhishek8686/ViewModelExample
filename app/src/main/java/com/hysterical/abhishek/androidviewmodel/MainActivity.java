package com.hysterical.abhishek.androidviewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hysterical.abhishek.androidviewmodel.adapter.HeroAdapter;
import com.hysterical.abhishek.androidviewmodel.model.Hero;
import com.hysterical.abhishek.androidviewmodel.view_model.HeroesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_view = findViewById(R.id.recycler_view);
        HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroes) {
                recycler_view.setAdapter(new HeroAdapter(MainActivity.this,heroes));
            }
        });
    }
}
