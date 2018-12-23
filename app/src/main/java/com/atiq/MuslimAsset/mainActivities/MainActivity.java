package com.atiq.MuslimAsset.mainActivities;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.atiq.MuslimAsset.ActivityHadith;
import com.atiq.MuslimAsset.ActivityHome;
import com.atiq.MuslimAsset.ActivityMore;
import com.atiq.MuslimAsset.ActivityPrayer;
import com.atiq.MuslimAsset.BottomNavigationViewHelper;
import com.atiq.MuslimAsset.R;


import com.atiq.MuslimAsset.database.DatabaseHelper;
import com.atiq.MuslimAsset.fragments.SuratFragment;
import com.atiq.MuslimAsset.util.configurations.settings;


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


        //Start Quran Activity Code

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:

                        break;
                    case R.id.ic_hadith:
                        Intent intent2 = new Intent(MainActivity.this,ActivityHadith.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_home:
                        Intent intent3 = new Intent(MainActivity.this,ActivityHome.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_prayers:
                        Intent intent4 = new Intent(MainActivity.this,ActivityPrayer.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_more:
                        Intent intent5 = new Intent(MainActivity.this,ActivityMore.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });



        //End Quran Activity code




        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        dbVersionPrefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);


        lang = sharedPreferences.getString(settings.LANG, settings.defaultLang);
        setLocaleEnglish();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, SuratFragment.newInstance())
                .commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DatabaseHelper.DATABASE_VERSION > dbVersionPrefs.getInt(settings.DATABASE_VERSION, 0)) {
            Log.d("MyActivity onResume()", "First Run or dbUpgrade");
            {

                new AsyncInsertData().execute();

            }
        }//End sharedPrefs checking

    }


    public void setLocaleEnglish() {
        Locale locale = new Locale(settings.LANG_EN);
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
