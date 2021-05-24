package com.android.animesearch;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimeLab {
    private static AnimeLab sAnimeLab;
    private List<Anime> mAnime;

    public static AnimeLab get(Context context) {
        if (sAnimeLab == null) {
            sAnimeLab = new AnimeLab(context);
        }
        return sAnimeLab;
    }
    private AnimeLab(Context context) {
        mAnime = new ArrayList<>();
    }

    public List<Anime> getAnime() {
        return mAnime;
    }

    public Anime getCrime(UUID id) {
        for (Anime anime : mAnime) {
            if (anime.getId().equals(id)) {
                return anime;
            } }
        return null;
    }
}