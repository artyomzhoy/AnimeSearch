package com.android.animesearch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.android.animesearch.R;
import com.android.animesearch.data.LocalAnimeRepository;
import com.android.animesearch.domain.SearchUseCase;

public class AnimeSearchFragment extends Fragment {

    private static final String ARG_SEARCH_TEXT = "search_text";

    private Button mSearchButton;
    private EditText mSearchView;

    private final AnimeSearchViewModel vm = new AnimeSearchViewModel(new SearchUseCase(new LocalAnimeRepository()));

    public static AnimeSearchFragment newInstance(String searchText) {
        return new AnimeSearchFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime_search, container, false);

        mSearchView = (EditText) view.findViewById(R.id.search_view);

        mSearchButton = (Button) view.findViewById(R.id.button_search);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = mSearchView.getText().toString();
                //Intent  intent= new Intent(getActivity(), AnimeListActivity.class);
                Intent intent = AnimeListActivity.newIntent(getActivity(), searchText);
                startActivity(intent);
            }
        });

        return view;
    }
}
