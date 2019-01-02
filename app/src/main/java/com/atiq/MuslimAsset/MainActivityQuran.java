package com.atiq.MuslimAsset;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;


import com.atiq.MuslimAsset.database.DatabaseHelper;
import com.atiq.MuslimAsset.fragments.SuratFragment;
import com.atiq.MuslimAsset.util.configurations.settings;


import java.util.Locale;


public class MainActivityQuran extends AppCompatActivity {

    static String language;
    SharedPreferences dbVersPreferences = null;
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
                        Intent intent2 = new Intent(MainActivityQuran.this,ActivityHadith.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_home:
                        Intent intent3 = new Intent(MainActivityQuran.this,ActivityHome.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_prayers:
                        Intent intent4 = new Intent(MainActivityQuran.this,ActivityPrayer.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_more:
                        Intent intent5 = new Intent(MainActivityQuran.this,ActivityMore.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });



        //End Quran Activity code




        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        dbVersPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);


        language = sharedPreferences.getString(settings.LANG, settings.defaultLang);
        setEnglish();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_box, SuratFragment.newInstance())
                .commit();






    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DatabaseHelper.DATABASE_VERSION > dbVersPreferences.getInt(settings.DATABASE_VERSION, 0)) {
            Log.d("MyActivity onResume()", "First Run or dbUpgrade");
            {

                new AsyncInsertData().execute();

            }
        }//End sharedPrefs checking

    }


    public void setEnglish() {
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




    // SearcView and setting view code starts
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //called when you clik search
                //myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //called whenever you type word in search view
                //myAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT ).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // SearcView and setting view code End

}
