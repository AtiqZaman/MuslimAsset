package com.sadaqaworks.quranprojects.database.datasource;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sadaqaworks.quranprojects.database.DatabaseHelper;
import com.sadaqaworks.quranprojects.model.Surah;

import java.util.ArrayList;


public class SurahDataSource {


    public final static String SURAH_ID = "_id";
    public final static String SURAH_ID_TAG = "surah_id";

    public final static String SURAH_NAME_ARABIC = "name_arabic";
    public final static String SURAH_NAME_ENGLISH = "name_english";
    public final static String SURAH_NAME_TRANSLATE = "name_translate";



    public final static String SURAH_AYAH_NUMBER = "ayah_number";

    private static Cursor cursor;
    private DatabaseHelper databaseHelper;

    public SurahDataSource(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public ArrayList<Surah> getEnglishSurahArrayList() {

        ArrayList<Surah> surahArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT surah_name._id,surah_name.name_arabic,surah_name.name_english,surah_name.ayah_number FROM surah_name", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Surah surah = new Surah();
            surah.setId(cursor.getLong(cursor.getColumnIndex(SURAH_ID)));
            surah.setNameArabic(cursor.getString(cursor.getColumnIndex(SURAH_NAME_ARABIC)));
            surah.setNameTranslate(cursor.getString(cursor.getColumnIndex(SURAH_NAME_ENGLISH)));
            surah.setAyahNumber(cursor.getLong(cursor.getColumnIndex(SURAH_AYAH_NUMBER)));
            surahArrayList.add(surah);
            cursor.moveToNext();

        }
        cursor.close();
        db.close();
        return surahArrayList;
    }

}