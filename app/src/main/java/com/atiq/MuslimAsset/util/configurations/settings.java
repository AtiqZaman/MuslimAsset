package com.atiq.MuslimAsset.util.configurations;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class settings {



    final public static String LANG = "lang";

    final public static String LANG_EN = "en";

    final public static String SHOW_TRANSLATION = "showTranslation";

    final public static String ARABIC_FONT = "arabicFont";
    final public static String FONT_SIZE_ARABIC = "fontSizeArabic";
    final public static String FONT_SIZE_TRANSLATION = "fontSizeTranslation";

    final public static String DATABASE_VERSION = "dbVersion";

    final public static String defaultLang = "en";
    final public static boolean defaultShowTranslation = true;


    final public static String defaultFontSizeArabic = "30";
    final public static String defaultFontSizeTranslation = "14";


    public boolean rtl;

    public String fontSizeArabic;



    public void load(Context context) {
        Log.d("settings", "Load");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            loadDefault();

            fontSizeArabic = sp.getString(settings.FONT_SIZE_ARABIC, settings.defaultFontSizeArabic);
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
