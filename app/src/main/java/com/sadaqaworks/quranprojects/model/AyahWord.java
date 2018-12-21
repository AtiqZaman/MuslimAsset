package com.sadaqaworks.quranprojects.model;

import java.util.ArrayList;


public class AyahWord {
    private ArrayList<Word> word;
    private String quranTranslate;
    private Long quranVerseId;

    public ArrayList<Word> getWord() {
        return word;
    }

    public void setWord(ArrayList<Word> word) {
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
