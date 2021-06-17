package com.android.animesearch.domain;

import com.android.animesearch.Anime;
import com.android.animesearch.data.AnimeRepository;

import java.util.List;

public class ApiSearchUseCase {

    private final AnimeRepository repository;

    public ApiSearchUseCase(AnimeRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Anime> execute(String searchText) {
        List<Anime> list = repository.getAnime(searchText);
        return list;
    }
}
