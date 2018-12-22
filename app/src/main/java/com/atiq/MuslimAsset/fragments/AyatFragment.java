package com.atiq.MuslimAsset.fragments;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.adapter.AyatAdapter;
import com.atiq.MuslimAsset.database.AyatDataSource;
import com.atiq.MuslimAsset.database.SuratDataSource;
import com.atiq.MuslimAsset.model.Ayat;
import com.atiq.MuslimAsset.util.ambient.Config;

import java.util.ArrayList;

import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;


public class AyatFragment extends Fragment {


    long surah_id;
    long ayah_number;
    String lang;
    private ArrayList<Ayat> ayatArrayList;
    private RecyclerView mRecyclerView;
    private AyatAdapter ayatAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public AyatFragment() {
        // empty public constructor is required
    }

    public static AyatFragment newInstance(Bundle bundle) {
        AyatFragment ayatFragment = new AyatFragment();
        ayatFragment.setArguments(bundle);
        return ayatFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        lang = sp.getString(Config.LANG, Config.defaultLang);
        surah_id = getArguments().getLong(SuratDataSource.SURAH_ID_TAG);
        ayah_number = getArguments().getLong(SuratDataSource.SURAH_AYAH_NUMBER);
        ayatArrayList = getAyahWordsBySurah(surah_id, ayah_number);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ayah_word, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_ayah_word_view);

        //for fast scroll
        VerticalRecyclerViewFastScroller fastScroller = view.findViewById(R.id.fast_scroller);

        // Connect the recycler to the scroller (to let the scroller scroll the list)
        fastScroller.setRecyclerView(mRecyclerView);

        // Connect the scroller to the recycler (to let the recycler scroll the scroller's handle)
        mRecyclerView.setOnScrollListener(fastScroller.getOnScrollListener());

        ayatAdapter = new AyatAdapter(ayatArrayList, getActivity(), surah_id);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        mRecyclerView.setAdapter(ayatAdapter);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setVerticalScrollBarEnabled(true);


        //set headerview
        RecyclerViewHeader recyclerViewHeader = view.findViewById(R.id.header);
        TextView headerTextView = recyclerViewHeader.findViewById(R.id.headerTextView);
        headerTextView.setText(getString(R.string.bismillah));
        recyclerViewHeader.attachTo(mRecyclerView, true);

    }

    public ArrayList<Ayat> getAyahWordsBySurah(long surah_id, long ayah_number) {
        ArrayList<Ayat> ayatArrayList = new ArrayList<Ayat>();
        AyatDataSource ayatDataSource = new AyatDataSource(getActivity());


        switch (lang) {

            case Config.LANG_EN:
                ayatArrayList = ayatDataSource.getEnglishAyahWordsBySurah(surah_id, ayah_number);
                break;
        }

        return ayatArrayList;
    }


}