package com.sadaqaworks.quranprojects.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadaqaworks.quranprojects.R;
import com.sadaqaworks.quranprojects.model.AyahWord;
import com.sadaqaworks.quranprojects.model.Word;
import com.sadaqaworks.quranprojects.util.settings.Config;
import com.sadaqaworks.quranprojects.view.layout.FlowLayout;

import java.util.ArrayList;




public class AyahWordAdapter extends RecyclerView.Adapter<AyahWordAdapter.AyahViewHolder> {

    static boolean showTranslation;


    static int fontSizeArabic;
    static int fontSizeTranslation;


    public Context context;
    long surah_id;
    private ArrayList<AyahWord> ayahWordArrayList;

    public AyahWordAdapter(ArrayList<AyahWord> ayahWordArrayList, Context context, long surah_id) {


        this.ayahWordArrayList = ayahWordArrayList;
        this.context = context;
        this.surah_id = surah_id;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        showTranslation = sharedPreferences.getBoolean(Config.SHOW_TRANSLATION, Config.defaultShowTranslation);
        fontSizeArabic = Integer.parseInt(sharedPreferences.getString(Config.FONT_SIZE_ARABIC, Config.defaultFontSizeArabic));
        fontSizeTranslation = Integer.parseInt(sharedPreferences.getString(Config.FONT_SIZE_TRANSLATION, Config.defaultFontSizeTranslation));

    }


    @Override
    public int getItemCount() {
        return ayahWordArrayList.size();
    }

    @Override
    public long getItemId(int position) {

        AyahWord ayahWord = ayahWordArrayList.get(position);
        long itemId = 1;

        for (Word word : ayahWord.getWord()) {
            itemId = word.getVerseId();
        }
        return itemId;
    }

    @Override
    public AyahWordAdapter.AyahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ayah_word, parent, false);
        AyahWordAdapter.AyahViewHolder viewHolder = new AyahWordAdapter.AyahViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AyahWordAdapter.AyahViewHolder holder, int position) {

        final AyahWord ayahWord = ayahWordArrayList.get(position);

        holder.verse_idTextView.setText("(" + Long.toString(ayahWord.getQuranVerseId()) + ")");


        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        holder.flow_word_by_word.removeAllViews();

        for (final Word word : ayahWord.getWord()) {

            final View view = inflater.inflate(R.layout.word_by_word, null);
            final TextView arabic = view.findViewById(R.id.word_arabic_textView);

            arabic.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSizeArabic);

            arabic.setText(fixArabic(word.getWordsAr()));

            holder.flow_word_by_word.addView(view);



        }

        holder.flow_word_by_word.setVisibility(View.VISIBLE);
        holder.arabic_textView.setVisibility(View.GONE);



        if (showTranslation) {
            holder.translate_textView.setText(ayahWord.getQuranTranslate());
            holder.translate_textView.setTextSize(fontSizeTranslation);
            holder.translate_textView.setVisibility(View.VISIBLE);
        }


    }



    private String fixArabic(String s) {
        // Add sukun on mem | nun
        s = s.replaceAll("([\u0645\u0646])([ \u0627-\u064A]|$)", "$1\u0652$2");
        // Tatweel + Hamza Above (joining chairless hamza) => Yeh With Hamza Above
        s = s.replaceAll("\u0640\u0654", "\u0626");
        return s;
    }

    public static class AyahViewHolder extends RecyclerView.ViewHolder {

        public TextView verse_idTextView;
        public FlowLayout flow_word_by_word;
        public TextView translate_textView;
        public TextView arabic_textView;

        public AyahViewHolder(View view) {
            super(view);
            verse_idTextView = view.findViewById(R.id.verse_id_textView);
            flow_word_by_word = view.findViewById(R.id.flow_word_by_word);
            translate_textView = view.findViewById(R.id.translate_textView);
            arabic_textView = view.findViewById(R.id.arabic_textView);
        }

    }


}