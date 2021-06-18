package com.android.animesearch.domain;

import com.android.animesearch.Anime;
import com.android.animesearch.data.AnimeRepository;

import java.util.Comparator;
import java.util.List;

public class ApiSearchUseCase {

    private final AnimeRepository repository;

    public ApiSearchUseCase(AnimeRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Anime> execute(String searchText) {
        List<Anime> list = repository.getAnime(searchText);

        Comparator<Anime> AnimeScoreComparator = new Comparator<Anime>() {

            @Override
            public int compare(Anime e1, Anime e2) {
                return e1.getTitleScore().compareTo(e2.getTitleScore());
            }
        };

        list.sort(AnimeScoreComparator.reversed());
        return list;
    }
}
