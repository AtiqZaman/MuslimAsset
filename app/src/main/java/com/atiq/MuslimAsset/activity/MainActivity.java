package com.atiq.MuslimAsset.activity;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.atiq.MuslimAsset.R;
import com.atiq.MuslimAsset.database.DatabaseHelper;
import com.atiq.MuslimAsset.fragment.SurahFragment;
import com.atiq.MuslimAsset.util.settings.Config;


import java.util.Locale;



public class MainActivity extends AppCompatActivity {

    static String lang;

    SharedPreferences dbVersionPrefs = null;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        dbVersionPrefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);


        lang = sharedPreferences.getString(Config.LANG, Config.defaultLang);
        setLocaleEnglish();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, SurahFragment.newInstance())
                .commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DatabaseHelper.DATABASE_VERSION > dbVersionPrefs.getInt(Config.DATABASE_VERSION, 0)) {
            Log.d("MyActivity onResume()", "First Run or dbUpgrade");
            {

                new AsyncInsertData().execute();

            }
        }//End sharedPrefs checking

    }


    public void setLocaleEnglish() {
        Locale locale = new Locale(Config.LANG_EN);
        Locale.setDefault(locale);



    }

    private class AsyncInsertData extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            Log.d("onInBackground()", "Data Inserting ");

            return null;
        }



    }

}
