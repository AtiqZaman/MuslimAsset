package com.atiq.MuslimAsset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.atiq.MuslimAsset.homeActivityFiles.Model;
import com.atiq.MuslimAsset.homeActivityFiles.MyAdapter;

import java.util.ArrayList;

public class ActivityHadith extends AppCompatActivity {


    RecyclerView mRecyclerView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadith);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Hadith");


        //Start recyclerview with card code

        //recyclerview
        mRecyclerView = findViewById(R.id.recycler_view);

        //set its proporties
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //Linear Layout
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //Grid Layout // here 2 means 2 columns in each rows

        //Adapter
        myAdapter = new MyAdapter(this, getPlayers());
        mRecyclerView.setAdapter(myAdapter);



        //Starts Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:
                        Intent intent1 = new Intent(ActivityHadith.this,MainActivityQuran.class);
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
                        Intent intent5 = new Intent(ActivityHadith.this, ActivityAccount.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });

        //Ends Bottom Navigation Bar

    }

    //Add models to array list
    private ArrayList<Model> getPlayers () {
        ArrayList<Model> models = new ArrayList<>();

        Model p;

        p = new Model();
        p.setTitleHeading(" Hadith#1 ");
        p.setTitleSubHeading(" Ṣaḥīḥ al-Bukhārī 54 ");
        p.setDiscriptionAranic("إِنَّمَا الْأَعْمَالُ بِالنِّيَّةِ ِ");
        p.setDiscriptionTrans("Verily, deeds are only with intentions.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#2 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 8 ");
        p.setDiscriptionAranic("أَنْ تُؤْمِنَ بِاللَّهِ وَمَلَائِكَتِهِ وَكُتُبِهِ وَرُسُلِهِ وَالْيَوْمِ الْآخِرِ وَتُؤْمِنَ بِالْقَدَرِ خَيْرِهِ وَشَرِّهِِ ِ");
        p.setDiscriptionTrans("Faith is to believe in Allah, His angels, His books, His messengers, the Last Day, and to believe in providence, both its good and its evil.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#3 ");
        p.setTitleSubHeading(" Ṣaḥīḥ al-Bukhārī 8 ");
        p.setDiscriptionAranic("بُنِيَ الْإِسْلَامُ عَلَى خَمْسٍ عَلَى أَنْ يُعْبَدَ اللَّهُ وَيُكْفَرَ بِمَا دُونَهُ وَإِقَامِ الصَّلَاةِ وَإِيتَاءِ الزَّكَاةِ وَحَجِّ الْبَيْتِ وَصَوْمِ رَمَضَانَِ ِ");
        p.setDiscriptionTrans("Islam is built upon five: to worship Allah and to disbelieve in what is worshiped besides him, to establish prayer, to give charity, to perform Hajj pilgrimage to the House, and to fast the month of Ramadan.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);


        p = new Model();
        p.setTitleHeading(" Hadith#4 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 1718 ");
        p.setDiscriptionAranic("مَنْ عَمِلَ عَمَلًا لَيْسَ عَلَيْهِ أَمْرُنَا فَهُوَ رَدٌَِّّ ِ");
        p.setDiscriptionTrans("Whoever performs a deed that is not in accordance with our matter will have it rejected.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);


        p = new Model();
        p.setTitleHeading(" Hadith#5 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 55 ");
        p.setDiscriptionAranic("إِنَّ الدِّينَ النَّصِيحَةُِ ِ");
        p.setDiscriptionTrans("Verily, the religion is sincerity.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);


        p = new Model();
        p.setTitleHeading(" Hadith#6 ");
        p.setTitleSubHeading(" SṢaḥīḥ Muslim 21 ");
        p.setDiscriptionAranic(" أُمِرْتُ أَنْ أُقَاتِلَ النَّاسَ حَتَّى يَقُولُوا لَا إِلَهَ إِلَّا اللَّهُ فَإِذَا قَالُوا لَا إِلَهَ إِلَّا اللَّهُ عَصَمُوا مِنِّي دِمَاءَهُمْ وَأَمْوَالَهُمْ إِلَّا بِحَقِّهَا وَحِسَابُهُمْ عَلَى اللَّهِِ ِ");
        p.setDiscriptionTrans("I have been commanded to fight the people until they say there is no God but Allah. If they say there is no God but Allah, then they will be granted protection from me for their lives and property, except by right of justice, and their reckoning is with Allah.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#7 ");
        p.setTitleSubHeading(" Ṣaḥīḥ al-Bukhārī 6858 ");
        p.setDiscriptionAranic("مَا نَهَيْتُكُمْ عَنْهُ فَاجْتَنِبُوهُ وَمَا أَمَرْتُكُمْ بِهِ فَافْعَلُوا مِنْهُ مَا اسْتَطَعْتُمْ فَإِنَّمَا أَهْلَكَ الَّذِينَ مِنْ قَبْلِكُمْ كَثْرَةُ مَسَائِلِهِمْ وَاخْتِلَافُهُمْ عَلَى أَنْبِيَائِهِمِْ ِ");
        p.setDiscriptionTrans("Avoid what I have forbidden for you and do what I have commanded you as much as you are able. Verily, the people before you were destroyed only because of their excessive questioning and differing with their prophets.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#8 ");
        p.setTitleSubHeading(" Sunan al-Tirmidhī 2518 ");
        p.setDiscriptionAranic("دَعْ مَا يَرِيبُكَ إِلَى مَا لَا يَرِيبُكَ فَإِنَّ الصِّدْقَ طُمَأْنِينَةٌ وَإِنَّ الْكَذِبَ رِيبَةٌِ ِ");
        p.setDiscriptionTrans("Leave what makes you doubt for what does not make you doubt. Verily, truth brings peace of mind and falsehood sows doubt.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#9 ");
        p.setTitleSubHeading(" Sunan al-Tirmidhī 2318 ");
        p.setDiscriptionAranic("إِنَّ مِنْ حُسْنِ إِسْلَامِ الْمَرْءِ تَرْكَهُ مَا لَا يَعْنِيهِ ِ");
        p.setDiscriptionTrans("Verily, from the perfection of Islam is that a person leaves what does not concern him.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#10 ");
        p.setTitleSubHeading(" Ṣaḥīḥ al-Bukhārī 13 ");
        p.setDiscriptionAranic("لا يُؤْمِنُ أَحَدُكُمْ حَتَّى يُحِبَّ لأَخِيهِ مَا يُحِبُّ لِنَفْسِهِِ ِ");
        p.setDiscriptionTrans("None of you has faith until he loves for his brother what he loves for himself.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#11 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 45 ");
        p.setDiscriptionAranic("لَا يُؤْمِنُ أَحَدُكُمْ حَتَّى يُحِبَّ لِأَخِيهِ أَوْ قَالَ لِجَارِهِ مَا يُحِبُّ لِنَفْسِهِِ ِ");
        p.setDiscriptionTrans("None of you has faith until he loves for his brother, or his neighbor, what he loves for himself.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#12 ");
        p.setTitleSubHeading(" Ḥilyat al-Awliyā’ 9/15 ");
        p.setDiscriptionAranic("ِ وَرَجُلٌ يَخْرُجُ مِنَ الْإِسْلَامِ فَيُحَارِبُ اللَّهَ وَرَسُوله ُِ");
        p.setDiscriptionTrans("And a man who leaves Islam and wages war against Allah and His messenger.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#13 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 47 ");
        p.setDiscriptionAranic(" مَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَالْيَوْمِ الآخِرِ فَلْيَقُلْ خَيْرًا أَوْ لِيَصْمُتْ وَمَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَالْيَوْمِ الآخِرِ فَلْيُكْرِمْ جَارَهُ وَمَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَالْيَوْمِ الآخِرِ فَلْيُكْرِمْ ضَيْفَهُ ِ");
        p.setDiscriptionTrans("Whoever believes in Allah and the Last Day, let him speak goodness or remain silent. Whoever believes in Allah and the Last Day, let him honor his neighbor. Whoever believes in Allah and the Last Day, let him honor his guest.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#14 ");
        p.setTitleSubHeading(" Ṣaḥīḥ al-Bukhārī 5765 ");
        p.setDiscriptionAranic("ِ  لَا تَغْضَبْ ُِ");
        p.setDiscriptionTrans("Do not be angry.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#15 ");
        p.setTitleSubHeading(" Sunan al-Tirmidhī 1987 ");
        p.setDiscriptionAranic("ِ   اتَّقِ اللَّهِ حَيْثُمَا كُنْتَ وَأَتْبِعْ السَّيِّئَةَ الْحَسَنَةَ تَمْحُهَا وَخَالِقِ النَّاسَ بِخُلُقٍ حَسَنٍ ُِ");
        p.setDiscriptionTrans("Be mindful of Allah wherever you are, follow a bad deed with a good deed and it will erase it, and behave with good character toward people.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#16 ");
        p.setTitleSubHeading(" Musnad Ahmad 2800 ");
        p.setDiscriptionAranic("ِ  وَاعْلَمْ أَنَّ فِي الصَّبْرِ عَلَى مَا تَكْرَهُ خَيْرًا كَثِيرًا وَأَنَّ النَّصْرَ مَعَ الصَّبْرِ وَأَنَّ الْفَرَجَ مَعَ الْكَرْبِ وَأَنَّ مَعَ الْعُسْرِ يُسْرًا ُِ");
        p.setDiscriptionTrans("Know that there is much good in being patient with what you detest, that victory will come with patience, affliction will come with relief, and hardship will come with ease.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#17 ");
        p.setTitleSubHeading(" Ṣaḥīḥ al-Bukhārī 3296 ");
        p.setDiscriptionAranic("ِ  إِنَّ مِمَّا أَدْرَكَ النَّاسُ مِنْ كَلَامِ النُّبُوَّةِ إِذَا لَمْ تَسْتَحْيِ فَافْعَلْ مَا شِئْتَ ُِ");
        p.setDiscriptionTrans(" Verily, among the words people obtained from the prophets are this: If you feel no shame, then do as you wish.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#18 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 38 ");
        p.setDiscriptionAranic("ِ  قُلْ آمَنْتُ بِاللَّهِ فَاسْتَقِمْ ُِ");
        p.setDiscriptionTrans("Say, ‘I have faith in Allah,’ and then remain steadfast.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#19 ");
        p.setTitleSubHeading(" Ṣaḥīḥ Muslim 2553 ");
        p.setDiscriptionAranic("ِ   الْبِرُّ حُسْنُ الْخُلُقِ وَالإِثْمُ مَا حَاكَ فِي صَدْرِكَ وَكَرِهْتَ أَنْ يَطَّلِعَ عَلَيْهِ النَّاسُ ُِ");
        p.setDiscriptionTrans("Righteousness is good character and sin is what waivers in your heart and you hate for people to find out about it.");
        p.setImg(R.drawable.hadithicon);
        models.add(p);

        p = new Model();
        p.setTitleHeading(" Hadith#20 ");
        p.setTitleSubHeading(" Sunan Ibn Mājah 2340 ");
        p.setDiscriptionAranic("ِ   لاَ ضَرَرَ وَلاَ ضِرَارَ ُِ");
        p.setDiscriptionTrans(" Do not cause harm or return harm. ");
        p.setImg(R.drawable.hadithicon);
        models.add(p);



        return models;
    }
}
