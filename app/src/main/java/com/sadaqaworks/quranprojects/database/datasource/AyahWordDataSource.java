package com.sadaqaworks.quranprojects.database.datasource;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sadaqaworks.quranprojects.database.DatabaseHelper;
import com.sadaqaworks.quranprojects.model.AyahWord;
import com.sadaqaworks.quranprojects.model.Word;
import java.util.ArrayList;

public class AyahWordDataSource {

    public final static String AYAHWORD_WORDS_TRANSLATE_EN = "translate_en";

    public final static String AYAHWORD_VERSE_ID = "verse_id";
    public final static String AYAHWORD_WORDS_ID = "words_id";
    public final static String AYAHWORD_WORDS_AR = "words_ar";

    public final static String QURAN_ENGLSIH = "english";
    private final static String QURAN_VERSE_ID = "verse_id";


    private static Cursor cursor;
    private static Cursor quranCursor;


    private DatabaseHelper databaseHelper;

    public AyahWordDataSource(Context context) {

        databaseHelper = new DatabaseHelper(context);
    }

    public ArrayList<AyahWord> getEnglishAyahWordsBySurah(long surah_id, long ayah_number)

    {
        long tempVerseWord;
        long tempVerseQuran;
        ArrayList<AyahWord> ayahWordArrayList = new ArrayList<AyahWord>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT bywords._id,bywords.surah_id,bywords.verse_id,bywords.words_id,bywords.words_ar,bywords.translate_en FROM bywords where bywords.surah_id = " + surah_id, null);
        cursor.moveToFirst();

        quranCursor = db.rawQuery("SELECT quran.verse_id,quran.arabic,quran.english from quran WHERE quran.surah_id = " + surah_id, null);
        quranCursor.moveToFirst();

        // while (!cursor.isAfterLast()) {

        for (long i = 1; i <= ayah_number; i++) {

            tempVerseWord = i;
            tempVerseQuran = i;

            AyahWord ayahWord = new AyahWord();
            ArrayList<Word> wordArrayList = new ArrayList<Word>();

            while (i == tempVerseWord && !cursor.isAfterLast()) {

                tempVerseWord = cursor.getLong(cursor.getColumnIndex(AYAHWORD_VERSE_ID));
                if (tempVerseWord != i) {
                    continue;
                }
                Word word = new Word();

                word.setVerseId(cursor.getLong(cursor.getColumnIndex(AYAHWORD_VERSE_ID)));
                word.setWordsId(cursor.getLong(cursor.getColumnIndex(AYAHWORD_WORDS_ID)));
                word.setWordsAr(cursor.getString(cursor.getColumnIndex(AYAHWORD_WORDS_AR)));
                word.setTranslate(cursor.getString(cursor.getColumnIndex(AYAHWORD_WORDS_TRANSLATE_EN)));

                wordArrayList.add(word);
                cursor.moveToNext();
            }


            while (i == tempVerseQuran && !quranCursor.isAfterLast()) {
                tempVerseQuran = quranCursor.getLong(quranCursor.getColumnIndex(QURAN_VERSE_ID));
                if (tempVerseQuran != i) {
                    continue;
                }
                ayahWord.setQuranVerseId(quranCursor.getLong(quranCursor.getColumnIndex(QURAN_VERSE_ID)));

                ayahWord.setQuranTranslate(quranCursor.getString(quranCursor.getColumnIndex(QURAN_ENGLSIH)));

                quranCursor.moveToNext();

            }

            ayahWord.setWord(wordArrayList);
            ayahWordArrayList.add(ayahWord);
        }


        quranCursor.close();
        cursor.close();
        db.close();
        return ayahWordArrayList;
    }


}
