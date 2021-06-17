package com.android.animesearch.data;

import com.android.animesearch.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> getAnime(String searchText);
}
