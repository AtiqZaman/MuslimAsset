package com.atiq.MuslimAsset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;


import com.atiq.MuslimAsset.homeActivityFiles.Model;
import com.atiq.MuslimAsset.homeActivityFiles.MyAdapter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class ActivityHome extends AppCompatActivity {


    private RelativeLayout topWidgetLayout;

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");


        // start hijri data

        // end hojri data

        findViewById(R.id.digitalClock);


        // start random background images

        topWidgetLayout = (RelativeLayout) findViewById(R.id.topwidgetlayout);

        Timer timerBackgroundImage = new Timer();
        MyTimer mt = new MyTimer();

        timerBackgroundImage.schedule(mt, 20000, 20000);

        // End background random images


        //Start recyclerview with card code

        //recyclerview
        mRecyclerView = findViewById(R.id.recycler_view);

        //set its proporties
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //Linear Layout
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //Grid Layout // here 2 means 2 columns in each rows

        //Adapter
        myAdapter = new MyAdapter(this, getPlayers());
        mRecyclerView.setAdapter(myAdapter);

        //End recyclerview with card


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:
                        Intent intent1 = new Intent(ActivityHome.this,MainActivityQuran.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_hadith:
                        Intent intent2 = new Intent(ActivityHome.this,ActivityHadith.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_home:

                        break;
                    case R.id.ic_prayers:
                        Intent intent4 = new Intent(ActivityHome.this,ActivityPrayer.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_more:
                        Intent intent5 = new Intent(ActivityHome.this,ActivityMore.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });

    }



    //start remaining code of random background images
    class MyTimer extends TimerTask {

        public void run() {

            runOnUiThread(new Runnable() {
                public void run() {

                    int Images[] = { R.drawable.homebackground, R.drawable.homebackground1, R.drawable.homebackground3,
                            R.drawable.homebackground4, R.drawable.homebackground6, R.drawable.homebackground7 };
                    //mylay.setBackgroundResource(Images[getRandomNumber()]);
                    topWidgetLayout.setBackgroundResource(Images[getRandomNumber()]);
                }

                private int getRandomNumber() {
                    // TODO Auto-generated method stub
                    return new Random().nextInt(5);}
            });
        }
    }

    //End remaining code of random background images



    //Add models to array list
    private ArrayList<Model> getPlayers () {
        ArrayList<Model> models = new ArrayList<>();

        Model p;

        p = new Model();
        p.setTitleHeading(" Verse of the Day ");
        p.setTitleSubHeading(" Al-Mursalat- 77:44 ");
        p.setDiscriptionAranic("إِنَّا كَذَلِكَ نَجْزِي الْمُحْسِنين");
        p.setDiscriptionTrans("Thus, behold, do We reward the doers of good");
        p.setImg(R.drawable.reading_quran);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Dua of the day ");
        p.setTitleSubHeading(" 3 ");
        p.setDiscriptionAranic("الْحَمْدُ لِلَّهِ الَّذِي أَقَالَنَا يَوْمَنَا هَذَا وَلَمْ يُهْلِكْنَا بِذُنُوبِنَا (مُسْلِمْ)");
        p.setDiscriptionTrans("All praise be to Allah who has forgiven us today and not destroyed us due to our sin.");
        p.setImg(R.drawable.ic_dua_hands);
        models.add(p);

        p = new Model();
        p.setTitleHeading("Hadith of the day");
        p.setTitleSubHeading("Al-Mursalat-(77:44)");
        p.setDiscriptionAranic("نَّمَا الْأَعْمَالُ بِالنِّيَّةِ وَإِنَّمَا لِامْرِئٍ مَا نَوَى فَمَنْ كَانَتْ هِجْرَتُهُ إِلَى اللَّهِ وَرَسُولِهِ فَهِجْرَتُهُ إِلَى اللَّهِ وَرَسُولِهِ وَمَنْ كَانَتْ هِجْرَتُهُ لِدُنْيَا يُصِيبُهَا أَوْ امْرَأَةٍ يَتَزَوَّجُهَا فَهِجْرَتُهُ إِلَى مَا هَاجَرَ إِلَيْهِ");
        p.setDiscriptionTrans("Verily, deeds are only with intentions. Verily, every person will have only what they intended. Whoever emigrated to Allah and His Messenger, then his emigration is for Allah and His Messenger." +
                " Whoever emigrated to get something in the world or to marry a woman, then his emigration is for whatever he emigrated for.");
        p.setImg(R.drawable.kuran);
        models.add(p);


        p = new Model();
        p.setTitleHeading("Allah names");
        p.setTitleSubHeading("1");
        p.setDiscriptionAranic("الرحمن");
        p.setDiscriptionTrans("The Most Gracious");
        p.setImg(R.drawable.namepaks);
        models.add(p);


        return models;
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
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //called whenever you type word in search view
                myAdapter.getFilter().filter(newText);
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
