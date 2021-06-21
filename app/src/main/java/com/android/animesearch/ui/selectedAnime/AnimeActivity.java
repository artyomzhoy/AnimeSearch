package com.android.animesearch.ui.selectedAnime;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.animesearch.SingleFragmentActivity;

import java.util.UUID;

public class AnimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_ANIME_ID =
            "com.android.animesearch.anime_id";
    private static final String ARG_ANIME_ID = "anime_id";


    public static Intent newIntent(Context packageContext, UUID animeId) {
        Intent intent = new Intent(packageContext, AnimeActivity.class);
        intent.putExtra(ARG_ANIME_ID, animeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID animeID = (UUID) getIntent().getSerializableExtra(ARG_ANIME_ID);
        return AnimeFragment.newInstance(animeID);
    }
}
