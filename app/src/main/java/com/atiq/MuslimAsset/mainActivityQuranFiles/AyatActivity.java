package com.atiq.MuslimAsset.mainActivityQuranFiles;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.database.SuratDataSource;
import com.atiq.MuslimAsset.fragments.AyatFragment;

public class AyatActivity extends AppCompatActivity {

    static public String surahName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = this.getIntent().getExtras();
        surahName = bundle.getString(SuratDataSource.suratNameTrans);
        getSupportActionBar().setTitle(surahName);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.main_box, AyatFragment.newInstance(bundle))
                    .commit();
        }

    }

}
