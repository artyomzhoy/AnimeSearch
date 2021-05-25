package com.android.animesearch;

import java.io.File;
import java.util.Date;

public class Anime {

    private int mTitleNameID;
    private int mTitleSubjectId;
    private int mTitleRating;
    private int mTitleStartDate;
    private int mTitlePicture;


    public Anime (int titleNameID, int titleSubjectId, int titleRating, int titlePicture, int titleStartDate) {
        mTitleNameID = titleNameID;
        mTitleSubjectId = titleSubjectId;
        mTitleRating = titleRating;
        mTitlePicture = titlePicture;
        mTitleStartDate = titleStartDate;
    }

    public int getTitleNameID() {
        return mTitleNameID;
    }

    public void setTitleNameID(int titleNameID) {
        mTitleNameID = titleNameID;
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
