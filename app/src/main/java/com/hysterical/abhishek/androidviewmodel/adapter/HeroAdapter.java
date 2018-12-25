package com.hysterical.abhishek.androidviewmodel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hysterical.abhishek.androidviewmodel.R;
import com.hysterical.abhishek.androidviewmodel.model.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Hero hero = heroList.get(i);
        Glide.with(mCtx)
                .load(hero.getImageurl())
                .into(viewHolder.imageView);

        viewHolder.textView.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
