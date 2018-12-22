package com.atiq.MuslimAsset;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.atiq.MuslimAsset.util.ambient.Config;

public class App extends Application {
    public static App app;
    final public Config config = new Config();
    SharedPreferences sharedPreferences;


    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        app = this;
        config.load(this);
        Log.e("app ", "onCreate");
        //loadFont();
    }


}
