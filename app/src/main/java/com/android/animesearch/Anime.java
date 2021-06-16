package com.android.animesearch;

public class Anime {

    private String mTitleName;
    private String mTitleSubjectId;
    private String mTitleScore;
    private String mTitleStartDate;
    private int mTitlePicture;

    public Anime(String titleName, String titleSubjectId, String titleScore, int titlePicture, String titleStartDate) {
        mTitleName = titleName;
        mTitleSubjectId = titleSubjectId;
        mTitleScore = titleScore;
        mTitlePicture = titlePicture;
        mTitleStartDate = titleStartDate;
    }

    public String getTitleName() {
        return mTitleName;
    }

    public void setTitleName(String titleName) {
        mTitleName = titleName;
    }

    public String getTitleSubjectId() {
        return mTitleSubjectId;
    }

    public void setTitleSubjectId(String titleSubjectId) {
        mTitleSubjectId = titleSubjectId;
    }

    public String getTitleScore() {
        return mTitleScore;
    }

    public void setTitleScore(String titleScore) {
        mTitleScore = titleScore;
    }

    public String getTitleStartDate() {
        return mTitleStartDate;
    }

    public void setTitleStartDate(String titleStartDate) {
        mTitleStartDate = titleStartDate;
    }

    public int getTitlePicture() {
        return mTitlePicture;
    }

    public void setTitlePicture(int titlePicture) {
        mTitlePicture = titlePicture;
    }
}
