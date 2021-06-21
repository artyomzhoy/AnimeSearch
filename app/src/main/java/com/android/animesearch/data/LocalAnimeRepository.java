package com.android.animesearch.data;

import com.android.animesearch.Anime;
import com.android.animesearch.R;

import java.util.Arrays;
import java.util.List;

public class LocalAnimeRepository implements AnimeRepository {

    public static Anime[] mAnimeBank = new Anime[] {
            new Anime(),
            new Anime(),
            new Anime(),
            new Anime(),
            new Anime(),
            new Anime()
    };

    @Override
    public List<Anime> getAnime(String searchText) {
        return Arrays.asList(mAnimeBank);
    }
}
