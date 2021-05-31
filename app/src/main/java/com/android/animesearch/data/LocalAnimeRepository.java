package com.android.animesearch.data;

import com.android.animesearch.Anime;
import com.android.animesearch.AnimeListActivity;
import com.android.animesearch.R;

import java.util.Arrays;
import java.util.List;

public class LocalAnimeRepository implements AnimeRepository {

    public static Anime[] mAnimeBank = new Anime[] {
            new Anime(R.string.anime_title_1, R.string.anime_subject_1, R.string.anime_rank_1, R.drawable.ic_baseline_whatshot_24, R.string.anime_date_1),
            new Anime(R.string.anime_title_2, R.string.anime_subject_2, R.string.anime_rank_2,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_2),
            new Anime(R.string.anime_title_3, R.string.anime_subject_3, R.string.anime_rank_3,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_3),
            new Anime(R.string.anime_title_4, R.string.anime_subject_4, R.string.anime_rank_4,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_4),
            new Anime(R.string.anime_title_5, R.string.anime_subject_5, R.string.anime_rank_5,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_5),
            new Anime(R.string.anime_title_6, R.string.anime_subject_6, R.string.anime_rank_6,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_6),
            new Anime(R.string.anime_title_6, R.string.anime_subject_6, R.string.anime_rank_6,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_6),
            new Anime(R.string.anime_title_6, R.string.anime_subject_6, R.string.anime_rank_6,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_6),
            new Anime(R.string.anime_title_6, R.string.anime_subject_6, R.string.anime_rank_6,R.drawable.ic_baseline_whatshot_24, R.string.anime_date_6)
    };

    @Override
    public List<Anime> getAnime() {
        return Arrays.asList(mAnimeBank);
    }
}
