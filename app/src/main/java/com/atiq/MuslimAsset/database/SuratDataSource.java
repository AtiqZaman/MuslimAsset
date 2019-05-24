package com.atiq.MuslimAsset.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.atiq.MuslimAsset.model.Surat;

import java.util.ArrayList;


public class SuratDataSource {


    public final static String suratID = "_id";
    public final static String suratIDtag = "surah_id";

    public final static String suratNameArabic = "name_arabic";
    public final static String suratNameEng = "name_english";
    public final static String suratNameTrans = "name_translate";



    public final static String suratAyahNumber = "ayah_number";

    private static Cursor cursor;
    private DatabaseHelper databaseHelper;

    public SuratDataSource(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public ArrayList<Surat> getEnglishSurahArrayList() {

        ArrayList<Surat> suratArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT surah_name._id,surah_name.name_arabic,surah_name.name_english,surah_name.ayah_number FROM surah_name", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Surat surat = new Surat();
            surat.setId(cursor.getLong(cursor.getColumnIndex(suratID)));
            surat.setNameArabic(cursor.getString(cursor.getColumnIndex(suratNameArabic)));
            surat.setNameTranslate(cursor.getString(cursor.getColumnIndex(suratNameEng)));
            surat.setAyahNumber(cursor.getLong(cursor.getColumnIndex(suratAyahNumber)));
            suratArrayList.add(surat);
            cursor.moveToNext();

        }
        cursor.close();
        db.close();
        return suratArrayList;
    }

}