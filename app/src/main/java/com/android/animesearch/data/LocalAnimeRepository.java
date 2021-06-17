package com.android.animesearch.data;

import com.android.animesearch.Anime;
import com.android.animesearch.R;

import java.util.Arrays;
import java.util.List;

public class LocalAnimeRepository implements AnimeRepository {

    public static Anime[] mAnimeBank = new Anime[] {
            new Anime("w", "w", "w", R.drawable.ic_baseline_whatshot_24, "w"),
            new Anime("1", "1", "1",R.drawable.ic_baseline_whatshot_24, "1"),
            new Anime("2", "2", "2",R.drawable.ic_baseline_whatshot_24, "2"),
            new Anime("afgasgf", "afgasgf", "afgasgf",R.drawable.ic_baseline_whatshot_24, "afgasgf"),
            new Anime("sjrt", "sjrt", "sjrt",R.drawable.ic_baseline_whatshot_24, "sjrt"),
            new Anime("asdgasg", "asdgasg", "asdgasg",R.drawable.ic_baseline_whatshot_24, "asdgasg")
    };

    @Override
    public List<Anime> getAnime(String searchText) {
        return Arrays.asList(mAnimeBank);
    }
}
