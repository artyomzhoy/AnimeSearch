package com.android.animesearch;

import java.io.File;
import java.util.Date;

public class Anime {

    private int mTitleNameID;
    private int mTitleSubjectId;
    private int mTitleRating;
    private Date mTitleStartDate;
    private int mTitlePicture;


    public Anime (int titleNameID, int titleSubjectId, int titleRating, int titlePicture) {
        mTitleNameID = titleNameID;
        mTitleSubjectId = titleSubjectId;
        mTitleRating = titleRating;
        mTitlePicture = titlePicture;
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
}
