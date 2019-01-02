package com.atiq.MuslimAsset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


import com.atiq.MuslimAsset.homeActivityFiles.Model;
import com.atiq.MuslimAsset.homeActivityFiles.MyAdapter;
import com.atiq.MuslimAsset.mainActivities.MainActivityQuran;

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

        Model p = new Model();
        p.setTitle(" Verse of the Day ");
        p.setDiscription("This is the sample discription of the batteries. this can be log or multiple line discription" +
                "An essay is generally a short piece of writing outlining the writer's perspective or story. " +
                "It is often considered synonymous with a story or a paper or an article");
        p.setImg(R.drawable.reading_quran);
        models.add(p);


        p = new Model();
        p.setTitle("Dua of the Day");
        p.setDiscription("this is the sample discription of the cpu. this can be log or multiple line discription");
        p.setImg(R.drawable.reading_quran);
        models.add(p);

        p = new Model();
        p.setTitle("Hadith of the day");
        p.setDiscription("this is the sample discription of the display. this can be log or multiple line discription");
        p.setImg(R.drawable.reading_quran);
        models.add(p);


        p = new Model();
        p.setTitle("Allah names");
        p.setDiscription("this is the sample discription of the general. this can be log or multiple line discription");
        p.setImg(R.drawable.reading_quran);
        models.add(p);


        return models;
    }


}
