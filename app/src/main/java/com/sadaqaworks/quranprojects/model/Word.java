package com.sadaqaworks.quranprojects.model;


public class Word {
    private long id;

    private long verseId;
    private long wordsId;
    private String wordsAr;
    private String translate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public long getVerseId() {
        return verseId;
    }

    public void setVerseId(long verseId) {
        this.verseId = verseId;
    }

    public long getWordsId() {
        return wordsId;
    }

    public void setWordsId(long wordsId) {
        this.wordsId = wordsId;
    }

    public String getWordsAr() {
        return wordsAr;
    }

    public void setWordsAr(String wordsAr) {
        this.wordsAr = wordsAr;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }


}
