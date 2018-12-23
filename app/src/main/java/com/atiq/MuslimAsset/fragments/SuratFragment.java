package com.atiq.MuslimAsset.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.mainActivities.AyatActivity;
import com.atiq.MuslimAsset.adapter.SuratAdapter;
import com.atiq.MuslimAsset.database.SuratDataSource;
import com.atiq.MuslimAsset.intrface.OnItemClickListener;
import com.atiq.MuslimAsset.model.Surat;
import com.atiq.MuslimAsset.util.configurations.settings;

import java.util.ArrayList;


public class SuratFragment extends Fragment {


    static String lang;
    private ArrayList<Surat> suratArrayList;
    private RecyclerView mRecyclerView;
    private SuratAdapter suratAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public SuratFragment() {
        // enpty constructor is required
    }

    public static SuratFragment newInstance() {
        SuratFragment suratFragment = new SuratFragment();
        return suratFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        lang = sp.getString(settings.LANG, settings.defaultLang);
        suratArrayList = getSuratArrayList();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_surah, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_surah_view);
        suratAdapter = new SuratAdapter(suratArrayList, getActivity());

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRecyclerView.setAdapter(suratAdapter);


        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        suratAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Surat surat = (Surat) suratAdapter.getItem(position);

                long surah_id = surat.getId(); //mRecyclerView.getAdapter().getItemId(position);
                long ayah_number = surat.getAyahNumber();
                String surah_name = surat.getNameTranslate();

                Log.d("SuratFragment", "ID: " + surah_id + " Surat Name: " + surah_name);

                Bundle dataBundle = new Bundle();
                dataBundle.putLong(SuratDataSource.SURAH_ID_TAG, surah_id);
                dataBundle.putLong(SuratDataSource.SURAH_AYAH_NUMBER, ayah_number);
                dataBundle.putString(SuratDataSource.SURAH_NAME_TRANSLATE, surah_name);

                Intent intent = new Intent(getActivity(), AyatActivity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);


            }
        });



    }

    private ArrayList<Surat> getSuratArrayList() {
        ArrayList<Surat> suratArrayList = new ArrayList<Surat>();
        SuratDataSource suratDataSource = new SuratDataSource(getActivity());

        switch (lang) {

            case settings.LANG_EN:
                suratArrayList = suratDataSource.getEnglishSurahArrayList();
                break;
        }

        return suratArrayList;
    }


}
