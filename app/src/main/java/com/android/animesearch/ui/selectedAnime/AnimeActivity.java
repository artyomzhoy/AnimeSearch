package com.android.animesearch.ui.selectedAnime;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.android.animesearch.Anime;
import com.android.animesearch.SingleFragmentActivity;

public class AnimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_ANIME = "com.android.animesearch.anime";

    public static Intent newIntent(Context packageContext, Anime anime) {
        Intent intent = new Intent(packageContext, AnimeActivity.class);
        intent.putExtra(EXTRA_ANIME, anime);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Anime anime = (Anime) getIntent().getSerializableExtra(EXTRA_ANIME);
        return AnimeFragment.newInstance(anime);
    }
}
