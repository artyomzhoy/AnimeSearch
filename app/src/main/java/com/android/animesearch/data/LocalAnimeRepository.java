package com.android.animesearch.data;

import com.android.animesearch.Anime;
import com.android.animesearch.R;

import java.util.Arrays;
import java.util.List;

public class LocalAnimeRepository implements AnimeRepository {

    public static Anime[] mAnimeBank = new Anime[] {
            new Anime("w", "w", "w", "w", "w"),
            new Anime("1", "1", "1","1", "1"),
            new Anime("2", "2", "2","2", "2"),
            new Anime("afgasgf", "afgasgf", "afgasgf","afgasgf", "afgasgf"),
            new Anime("sjrt", "sjrt", "sjrt","sjrt", "sjrt"),
            new Anime("asdgasg", "asdgasg", "asdgasg","asdgasg", "asdgasg")
    };

    @Override
    public List<Anime> getAnime(String searchText) {
        return Arrays.asList(mAnimeBank);
    }
}
