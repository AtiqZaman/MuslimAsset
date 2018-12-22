package com.atiq.MuslimAsset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.atiq.MuslimAsset.mainActivities.MainActivity;

public class ActivityHome extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView title = (TextView) findViewById(R.id.homeActivity);
        title.setText("This is Main Activity");


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:
                        Intent intent1 = new Intent(ActivityHome.this,MainActivity.class);
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


}
