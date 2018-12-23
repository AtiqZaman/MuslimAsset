package com.atiq.MuslimAsset;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.atiq.MuslimAsset.util.configurations.settings;

public class App extends Application {
    public static App app;
    final public settings settings = new settings();
    SharedPreferences sharedPreferences;


    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        app = this;
        settings.load(this);
        Log.e("app ", "onCreate");
        //loadFont();
    }


}
