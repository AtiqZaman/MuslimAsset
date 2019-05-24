package com.atiq.MuslimAsset.util.configurations;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class settings {



    final public static String language = "lang";

    final public static String english_laguage = "en";

    final public static String display_translation = "displayTranslation";


    final public static String arabicFontSize = "fontSizeArabic";
    final public static String translationFontSize = "fontSizeTranslation";

    final public static String db_version = "dbVersion";

    final public static String defualtLanguage = "en";
    final public static boolean defualtShowTrnslation = true;


    final public static String defaultFontSizeArabic = "30";
    final public static String defaultFontSizeTranslation = "14";


    public boolean rtl;

    public String fontSizeArabic;



    public void load(Context context) {
        Log.d("settings", "Load");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            loadDefault();

            fontSizeArabic = sp.getString(settings.arabicFontSize, settings.defaultFontSizeArabic);
            Log.d("settings", "Loading Custom");

        } catch (Exception e) {
            loadDefault();
            Log.d("settings", "Exception Loading Defaults");
        }
    }

    public void loadDefault() {

        fontSizeArabic = defaultFontSizeArabic;

    }




}
