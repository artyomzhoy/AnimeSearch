package com.android.animesearch.ui;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.animesearch.SingleFragmentActivity;

import java.util.UUID;

public class AnimeActivity extends SingleFragmentActivity {

//    public static final String EXTRA_ANIME_ID =
//            "com.android.animesearch.anime_id";
//
//    public static Intent newIntent(Context packageContext, UUID animeId) {
//        Intent intent = new Intent(packageContext, AnimeActivity.class);
//        intent.putExtra(EXTRA_ANIME_ID, animeId);
//        return intent;
//    }

    @Override
    protected Fragment createFragment() {
        return AnimeFragment.newInstance();
    }
}
