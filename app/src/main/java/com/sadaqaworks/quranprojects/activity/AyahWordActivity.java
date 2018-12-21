package com.sadaqaworks.quranprojects.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sadaqaworks.quranprojects.R;
import com.sadaqaworks.quranprojects.database.datasource.SurahDataSource;
import com.sadaqaworks.quranprojects.fragment.AyahWordFragment;

public class AyahWordActivity extends AppCompatActivity {

    static public String surahName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = this.getIntent().getExtras();
        surahName = bundle.getString(SurahDataSource.SURAH_NAME_TRANSLATE);
        getSupportActionBar().setTitle(surahName);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, AyahWordFragment.newInstance(bundle))
                    .commit();
        }

    }

}
