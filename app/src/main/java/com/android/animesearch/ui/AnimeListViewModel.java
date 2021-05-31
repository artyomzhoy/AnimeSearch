package com.android.animesearch.ui;

import androidx.lifecycle.ViewModel;

import com.android.animesearch.Anime;
import com.android.animesearch.domain.LoadPopularAnimeUseCase;

import java.util.List;

public class AnimeListViewModel extends ViewModel {

    private LoadPopularAnimeUseCase mLoadPopularAnimeUseCase;

    public AnimeListViewModel(LoadPopularAnimeUseCase loadPopularAnimeUseCase) {
        super();
        this.mLoadPopularAnimeUseCase = loadPopularAnimeUseCase;
    }

    public List<Anime> getAnimeList() {
        return mLoadPopularAnimeUseCase.execute();
    }


}
