package com.android.animesearch.ui;

import androidx.lifecycle.ViewModel;

import com.android.animesearch.Anime;
import com.android.animesearch.domain.ApiSearchUseCase;
import com.android.animesearch.domain.LoadPopularAnimeUseCase;
import com.android.animesearch.domain.SearchUseCase;

import java.util.List;

public class AnimeListViewModel extends ViewModel {

    private LoadPopularAnimeUseCase mLoadPopularAnimeUseCase;
    private SearchUseCase mSearchUseCase;
    private ApiSearchUseCase mApiSearchUseCase;

    public AnimeListViewModel(
            LoadPopularAnimeUseCase loadPopularAnimeUseCase,
            SearchUseCase searchUseCase,
            ApiSearchUseCase apiSearchUseCase
    ) {
        super();
        this.mLoadPopularAnimeUseCase = loadPopularAnimeUseCase;
        this.mSearchUseCase = searchUseCase;
        this.mApiSearchUseCase = apiSearchUseCase;
    }

    public List<Anime> getAnimeList() {
        return mLoadPopularAnimeUseCase.execute();
    }

    public List<Anime> getAnimeList(String filter) {
        return mSearchUseCase.execute(filter);
    }

    public List<Anime> getApiAnimeList(String filter) {
        return mApiSearchUseCase.execute(filter);
    }
}
