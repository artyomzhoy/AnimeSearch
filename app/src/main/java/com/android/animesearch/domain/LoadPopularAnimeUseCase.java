package com.android.animesearch.domain;

import com.android.animesearch.Anime;
import com.android.animesearch.data.AnimeRepository;

import java.util.List;

public class LoadPopularAnimeUseCase {

    private final AnimeRepository repository;

    public LoadPopularAnimeUseCase(AnimeRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Anime> execute() {
        List<Anime> list = repository.getAnime();
        return list;
    }
}
