package com.android.animesearch.data;

import com.android.animesearch.Anime;

import java.util.ArrayList;
import java.util.List;

public class RemoteAnimeRepository implements AnimeRepository {

    private Jikan jikan = new Jikan();

    @Override
    public List<Anime> getAnime(String searchText) {
        return jikan.fetchItems(searchText);
    }
}
