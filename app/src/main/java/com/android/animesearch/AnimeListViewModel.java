package com.android.animesearch;

import androidx.lifecycle.ViewModel;

import com.android.animesearch.data.AnimeRepository;

import java.util.List;

public class AnimeListViewModel extends ViewModel {

    private static AnimeRepository repository;

    public AnimeListViewModel(AnimeRepository repository) {
        super();
        AnimeListViewModel.repository = repository;
    }

    public List<Anime> getAnimeList() {
        return repository.getAnime();
    }


}
