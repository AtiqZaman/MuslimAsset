package com.atiq.MuslimAsset.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.atiq.MuslimAsset.model.Ayat;
import com.atiq.MuslimAsset.model.Word;
import java.util.ArrayList;

public class AyatDataSource {

    public final static String translate_EN = "translate_en";

    public final static String ayatVerse_ID = "verse_id";
    public final static String ayatWords_ID = "words_id";
    public final static String ayatWords_AR = "words_ar";

    public final static String QuranEnglish = "english";
    private final static String QuranVerseID = "verse_id";


    private static Cursor cursor;
    private static Cursor quranCursor;



    private DatabaseHelper databaseHelper;

    public AyatDataSource(Context context) {

        databaseHelper = new DatabaseHelper(context);
    }

    public ArrayList<Ayat> getEnglishAyatWordsBySurah(long surah_id, long ayatNumber)

    {
        long tempVerseWord;
        long tempVerseQuran;
        ArrayList<Ayat> ayatArrayList = new ArrayList<Ayat>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT bywords._id,bywords.surah_id,bywords.verse_id,bywords.words_id,bywords.words_ar,bywords.translate_en FROM bywords where bywords.surah_id = " + surah_id, null);
        cursor.moveToFirst();

        quranCursor = db.rawQuery("SELECT quran.verse_id,quran.arabic,quran.english from quran WHERE quran.surah_id = " + surah_id, null);
        quranCursor.moveToFirst();

        // while (!cursor.isAfterLast()) {

        for (long i = 1; i <= ayatNumber; i++) {

            tempVerseWord = i;
            tempVerseQuran = i;

            Ayat ayat = new Ayat();
            ArrayList<Word> wordArrayList = new ArrayList<Word>();

            while (i == tempVerseWord && !cursor.isAfterLast()) {

                tempVerseWord = cursor.getLong(cursor.getColumnIndex(ayatVerse_ID));
                if (tempVerseWord != i) {
                    continue;
                }
                Word word = new Word();

                word.setVerseId(cursor.getLong(cursor.getColumnIndex(ayatVerse_ID)));
                word.setWordsId(cursor.getLong(cursor.getColumnIndex(ayatWords_ID)));
                word.setWordsAr(cursor.getString(cursor.getColumnIndex(ayatWords_AR)));
                word.setTranslate(cursor.getString(cursor.getColumnIndex(translate_EN)));

                wordArrayList.add(word);
                cursor.moveToNext();
            }


            while (i == tempVerseQuran && !quranCursor.isAfterLast()) {
                tempVerseQuran = quranCursor.getLong(quranCursor.getColumnIndex(QuranVerseID));
                if (tempVerseQuran != i) {
                    continue;
                }
                ayat.setQuranVerseId(quranCursor.getLong(quranCursor.getColumnIndex(QuranVerseID)));

                ayat.setQuranTranslate(quranCursor.getString(quranCursor.getColumnIndex(QuranEnglish)));

                quranCursor.moveToNext();

            }

            ayat.setAyatWord(wordArrayList);
            ayatArrayList.add(ayat);
        }


        quranCursor.close();
        cursor.close();
        db.close();
        return ayatArrayList;
    }


}
