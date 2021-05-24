package com.android.animesearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class AnimeListActivity extends SingleFragmentActivity {

    public Anime[] mAnimeBank = new Anime[] {
            new Anime(R.string.anime_title_1, R.string.anime_subject_1, R.string.anime_rank_1, R.drawable.ic_baseline_whatshot_24),
            new Anime(R.string.anime_title_2, R.string.anime_subject_2, R.string.anime_rank_2,R.drawable.ic_baseline_whatshot_24),
            new Anime(R.string.anime_title_3, R.string.anime_subject_3, R.string.anime_rank_3,R.drawable.ic_baseline_whatshot_24),
            new Anime(R.string.anime_title_4, R.string.anime_subject_4, R.string.anime_rank_4,R.drawable.ic_baseline_whatshot_24),
            new Anime(R.string.anime_title_5, R.string.anime_subject_5, R.string.anime_rank_5,R.drawable.ic_baseline_whatshot_24),
            new Anime(R.string.anime_title_6, R.string.anime_subject_6, R.string.anime_rank_6,R.drawable.ic_baseline_whatshot_24)
    };
    private int mCurrentIndex = 0;

    @Override
    protected Fragment createFragment() {
        return new AnimeListFragment();
    }
}