package com.atiq.MuslimAsset.homeActivityFiles;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import com.atiq.MuslimAsset.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<Model> models, filterList;
    CustomFilter filter;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
        this.filterList = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Convert xml to view obj
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, null);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {


        holder.tvTitelHeading.setText(models.get(position).getTitleHeading());
        holder.tvTitleSubHeading.setText(models.get(position).getTitleSubHeading());
        holder.tvDescrArabic.setText(models.get(position).getDiscriptionAranic());
        holder.tvDescrTrans.setText(models.get(position).getDiscriptionTrans());
        holder.ivImage.setImageResource(models.get(position).getImg());

        //Animation
        Animation animation = AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {

        if(filter == null){
            filter =new CustomFilter(filterList, this);
        }
        return filter;
    }
}
