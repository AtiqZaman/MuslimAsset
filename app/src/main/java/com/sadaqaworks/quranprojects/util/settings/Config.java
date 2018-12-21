package com.sadaqaworks.quranprojects.util.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class Config {



    final public static String LANG = "lang";

    final public static String LANG_EN = "en";

    final public static String SHOW_TRANSLATION = "showTranslation";

    final public static String ARABIC_FONT = "arabicFont";
    final public static String FONT_SIZE_ARABIC = "fontSizeArabic";
    final public static String FONT_SIZE_TRANSLATION = "fontSizeTranslation";

    final public static String DATABASE_VERSION = "dbVersion";

    final public static String defaultLang = "en";
    final public static boolean defaultShowTranslation = true;

    final public static String defaultArabicFont = "PDMS_IslamicFont.ttf";
    final public static String defaultFontSizeArabic = "30";
    final public static String defaultFontSizeTranslation = "14";

    // public String lang;
    public boolean rtl;

    public String fontArabic;
    public String fontSizeArabic;



    public void load(Context context) {
        Log.d("Config", "Load");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            loadDefault();
            fontArabic = sp.getString(Config.ARABIC_FONT, Config.defaultArabicFont);
            fontSizeArabic = sp.getString(Config.FONT_SIZE_ARABIC, Config.defaultFontSizeArabic);
            Log.d("Config", "Loading Custom");

        } catch (Exception e) {
            loadDefault();
            Log.d("Config", "Exception Loading Defaults");
        }
    }

    public void loadDefault() {
        fontArabic = defaultArabicFont;
        fontSizeArabic = defaultFontSizeArabic;

    }




}
