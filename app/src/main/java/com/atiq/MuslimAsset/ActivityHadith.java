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

public class ActivityHadith extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadith);

        TextView title = (TextView) findViewById(R.id.hadithActivity);
        title.setText("This is Hadith Activity");



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:
                        Intent intent1 = new Intent(ActivityHadith.this,MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_hadith:

                        break;
                    case R.id.ic_home:
                        Intent intent3 = new Intent(ActivityHadith.this,ActivityHome.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_prayers:
                        Intent intent4 = new Intent(ActivityHadith.this,ActivityPrayer.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_more:
                        Intent intent5 = new Intent(ActivityHadith.this,ActivityMore.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });

    }
}
