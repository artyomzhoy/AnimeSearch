package com.android.animesearch;

public class Anime {

    private String mTitleName;
    private int mTitleSubjectId;
    private int mTitleRating;
    private int mTitleStartDate;
    private int mTitlePicture;

    public Anime(String titleName, int titleSubjectId, int titleRating, int titlePicture, int titleStartDate) {
        mTitleName = titleName;
        mTitleSubjectId = titleSubjectId;
        mTitleRating = titleRating;
        mTitlePicture = titlePicture;
        mTitleStartDate = titleStartDate;
    }

    public String getTitleName() {
        return mTitleName;
    }

    public void setTitleName(String titleName) {
        mTitleName = titleName;
    }

    public int getTitleSubjectId() {
        return mTitleSubjectId;
    }

    public void setTitleSubjectId(int titleSubjectId) {
        mTitleSubjectId = titleSubjectId;
    }

    public double getTitleRating() {
        return mTitleRating;
    }

    public void setTitleRating(int titleRating) {
        mTitleRating = titleRating;
    }

    public int getTitleStartDate() {
        return mTitleStartDate;
    }

    public void setTitleStartDate(int titleStartDate) {
        mTitleStartDate = titleStartDate;
    }

    public int getTitlePicture() {
        return mTitlePicture;
    }

    public void setTitlePicture(int titlePicture) {
        mTitlePicture = titlePicture;
    }
}
