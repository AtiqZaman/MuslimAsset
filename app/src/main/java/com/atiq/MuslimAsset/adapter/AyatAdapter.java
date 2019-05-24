package com.atiq.MuslimAsset.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.model.Ayat;
import com.atiq.MuslimAsset.model.Word;
import com.atiq.MuslimAsset.util.configurations.settings;
import com.atiq.MuslimAsset.view.layout.FlowLayout;

import java.util.ArrayList;




public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyahViewHolder> {

    static boolean displayTrans;


    static int arabicFontSize;
    static int translationFontSize;


    public Context context;
    long surahId;
    private ArrayList<Ayat> ayatArrayList;

    public AyatAdapter(ArrayList<Ayat> ayatArrayList, Context context, long surahId) {


        this.ayatArrayList = ayatArrayList;
        this.context = context;
        this.surahId = surahId;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        displayTrans = sharedPreferences.getBoolean(settings.SHOW_TRANSLATION, settings.defaultShowTranslation);
       arabicFontSize = Integer.parseInt(sharedPreferences.getString(settings.FONT_SIZE_ARABIC, settings.defaultFontSizeArabic));
        translationFontSize = Integer.parseInt(sharedPreferences.getString(settings.FONT_SIZE_TRANSLATION, settings.defaultFontSizeTranslation));

    }


    @Override
    public int getItemCount() {
        return ayatArrayList.size();
    }

    @Override
    public long getItemId(int position) {

        Ayat ayat = ayatArrayList.get(position);
        long itemId = 1;

        for (Word word : ayat.getAyatWord()) {
            itemId = word.getVerseId();
        }
        return itemId;
    }

    @Override
    public AyatAdapter.AyahViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ayah_word, parent, false);
        AyatAdapter.AyahViewHolder viewHolder = new AyatAdapter.AyahViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AyatAdapter.AyahViewHolder holder, int position) {

        final Ayat ayat = ayatArrayList.get(position);

        holder.verse_idTextView.setText("(" + Long.toString(ayat.getQuranVerseId()) + ")");


        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        holder.flow_word_by_word.removeAllViews();

        for (final Word word : ayat.getAyatWord()) {

            final View view = inflater.inflate(R.layout.word_by_word, null);
            final TextView arabic = view.findViewById(R.id.arabicWord_textView);

            arabic.setTextSize(TypedValue.COMPLEX_UNIT_SP, arabicFontSize);

            arabic.setText(fixArabic(word.getWordsAr()));

            holder.flow_word_by_word.addView(view);



        }

        holder.flow_word_by_word.setVisibility(View.VISIBLE);
        holder.arabic_textView.setVisibility(View.GONE);



        if (displayTrans) {
            holder.translate_textView.setText(ayat.getQuranTranslate());
            holder.translate_textView.setTextSize(translationFontSize);
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