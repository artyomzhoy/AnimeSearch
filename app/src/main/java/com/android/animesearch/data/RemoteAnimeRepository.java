package com.android.animesearch.data;

import com.android.animesearch.Anime;
import com.android.animesearch.Jikan;
import com.android.animesearch.ui.AnimeListFragment;

import java.util.ArrayList;
import java.util.List;

public class RemoteAnimeRepository implements AnimeRepository {

    List<Anime> mAnimeBank = new ArrayList<>();

    @Override
    public List<Anime> getAnime() {
        return mAnimeBank;
    }
}
