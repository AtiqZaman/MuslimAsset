package com.atiq.MuslimAsset.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.intrface.OnItemClickListener;
import com.atiq.MuslimAsset.model.Surat;

import java.util.ArrayList;


public class SuratAdapter extends RecyclerView.Adapter<SuratAdapter.SurahViewHolder> {

    OnItemClickListener mItemClickListener;
    private ArrayList<Surat> suratArrayList;



    public SuratAdapter(ArrayList<Surat> suratArrayList, Activity activity) {
        this.suratArrayList = suratArrayList;


    }


    @Override
    public SuratAdapter.SurahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_surah, parent, false);
        SuratAdapter.SurahViewHolder viewHolder = new SuratAdapter.SurahViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SuratAdapter.SurahViewHolder holder, int position) {

        Surat surat = suratArrayList.get(position);
        holder.surah_idTextView.setText(Long.toString(surat.getId()) + ".");
        holder.translateTextView.setText(surat.getNameTranslate());
        holder.arabicTextView.setText(surat.getNameArabic());


    }


    public Object getItem(int position) {

        return suratArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return suratArrayList.size();
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

