package com.android.animesearch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import com.android.animesearch.R;

public class AnimeSearchFragment extends Fragment {

    private Button mSearchButton;
    private SearchView mSearchView;

    public static AnimeSearchFragment newInstance () {
        return new AnimeSearchFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime_search, container, false);

    mSearchButton = (Button) view.findViewById(R.id.button_search);
    mSearchButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    mSearchView = (SearchView) view.findViewById(R.id.search_view);


    return view;
    }
}
