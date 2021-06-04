package com.android.animesearch.ui;

import androidx.lifecycle.ViewModel;

import com.android.animesearch.Anime;
import com.android.animesearch.domain.SearchUseCase;

import java.util.List;

public class AnimeSearchViewModel extends ViewModel {

    private SearchUseCase mSearchUseCase;

    public AnimeSearchViewModel(SearchUseCase searchUseCase) {
        super();
        this.mSearchUseCase = searchUseCase;
    }

    public void search(String text) {
         List<Anime> list =  mSearchUseCase.execute(text);
    }
}
