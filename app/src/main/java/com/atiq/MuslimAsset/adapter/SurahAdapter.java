package com.atiq.MuslimAsset.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.intrface.OnItemClickListener;
import com.atiq.MuslimAsset.model.Surah;

import java.util.ArrayList;


public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {

    OnItemClickListener mItemClickListener;
    private ArrayList<Surah> surahArrayList;



    public SurahAdapter(ArrayList<Surah> surahArrayList, Activity activity) {
        this.surahArrayList = surahArrayList;


    }


    @Override
    public SurahAdapter.SurahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_surah, parent, false);
        SurahAdapter.SurahViewHolder viewHolder = new SurahAdapter.SurahViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SurahAdapter.SurahViewHolder holder, int position) {

        Surah surah = surahArrayList.get(position);
        holder.surah_idTextView.setText(Long.toString(surah.getId()) + ".");
        holder.translateTextView.setText(surah.getNameTranslate());
        holder.arabicTextView.setText(surah.getNameArabic());


    }


    public Object getItem(int position) {

        return surahArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return surahArrayList.size();
    }


    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener//current clickListerner
    {
        public TextView translateTextView;

        public TextView surah_idTextView;

        public TextView arabicTextView;


        public SurahViewHolder(View view) {
            super(view);
            translateTextView = view.findViewById(R.id.translate_textView);
            arabicTextView = view.findViewById(R.id.arabic_textView);
            surah_idTextView = view.findViewById(R.id.surah_idTextView);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }

        }

    }

}

