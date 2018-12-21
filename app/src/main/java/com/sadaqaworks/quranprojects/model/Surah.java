package com.sadaqaworks.quranprojects.model;

public class Surah {
    private Long id;

    private String nameArabic;
    private String nameTranslate;


    private Long ayahNumber;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getNameArabic() {
        return nameArabic;
    }

    public void setNameArabic(String nameArabic) {
        this.nameArabic = nameArabic;
    }

    public String getNameTranslate() {
        return nameTranslate;
    }

    public void setNameTranslate(String nameTranslate) {
        this.nameTranslate = nameTranslate;
    }



    public Long getAyahNumber() {
        return ayahNumber;
    }

    public void setAyahNumber(Long ayahNumber) {
        this.ayahNumber = ayahNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
