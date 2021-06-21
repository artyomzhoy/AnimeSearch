package com.android.animesearch;

import java.io.Serializable;
import java.util.UUID;

public class Anime implements Serializable {

    private UUID mUUID;
    private String mTitleName;
    private String mTitleSubjectId;
    private String mTitleScore;
    private String mTitleStartDate;
    private String mTitlePicture;

    public Anime() {
        this(UUID.randomUUID());
    }

    public Anime(UUID id){
        mUUID = id;
    }

//    public Anime(String titleName, String titleSubjectId, String titleScore, String titlePicture, String titleStartDate) {
//        this(UUID.randomUUID());
//        mTitleName = titleName;
//        mTitleSubjectId = titleSubjectId;
//        mTitleScore = titleScore;
//        mTitlePicture = titlePicture;
//        mTitleStartDate = titleStartDate;
//    }

    public UUID getId() {
        return mUUID;
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

    public String getTitlePicture() {
        return mTitlePicture;
    }

    public void setTitlePicture(String titlePicture) {
        mTitlePicture = titlePicture;
    }

}
