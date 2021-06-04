package com.android.animesearch.domain;

import com.android.animesearch.Anime;
import com.android.animesearch.data.AnimeRepository;

import java.util.LinkedList;
import java.util.List;

public class SearchUseCase {

    private final AnimeRepository repository;

    public SearchUseCase(AnimeRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Anime> execute(String text) {
        List<Anime> list = repository.getAnime();
        List<Anime> result = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            Anime a = list.get(i);

            if (a.getTitleName().contains(text)) {
                result.add(a);
            }
        }
        return result;
    }
}
