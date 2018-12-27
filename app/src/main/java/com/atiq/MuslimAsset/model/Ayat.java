package com.atiq.MuslimAsset.model;

import java.util.ArrayList;


public class Ayat {
    private ArrayList<Word> word;
    private String quranTranslate;
    private Long quranVerseId;

    public ArrayList<Word> getAyatWord() {
        return word;
    }

    public void setAyatWord(ArrayList<Word> word) {
        this.word = word;
    }

    public String getQuranTranslate() {
        return quranTranslate;
    }

    public void setQuranTranslate(String quranTranslate) {
        this.quranTranslate = quranTranslate;
    }

    public Long getQuranVerseId() {
        return quranVerseId;
    }

    public void setQuranVerseId(Long quranVerseId) {
        this.quranVerseId = quranVerseId;
    }
}
