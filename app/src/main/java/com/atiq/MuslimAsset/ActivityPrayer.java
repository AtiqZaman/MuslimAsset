package com.atiq.MuslimAsset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.atiq.MuslimAsset.mainActivities.MainActivity;

public class ActivityPrayer extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);

        TextView title = (TextView) findViewById(R.id.activityPrayers);
        title.setText("This is Prayers Activity ");


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);


        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:
                        //Intent intent1 = new Intent(ActivityPrayer.this,ActivityQuran.class);
                        //startActivity(intent1);
                        break;
                    case R.id.ic_hadith:
                        Intent intent2 = new Intent(ActivityPrayer.this,MainActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_home:
                        Intent intent3 = new Intent(ActivityPrayer.this,ActivityHome.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_prayers:

                        break;
                    case R.id.ic_more:
                        Intent intent5 = new Intent(ActivityPrayer.this,ActivityMore.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });

    }
}
