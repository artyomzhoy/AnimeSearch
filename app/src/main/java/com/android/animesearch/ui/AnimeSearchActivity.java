package com.android.animesearch.ui;

import androidx.fragment.app.Fragment;

import com.android.animesearch.SingleFragmentActivity;

public class AnimeSearchActivity extends SingleFragmentActivity {

    private static final String ARG_SEARCH_TEXT = "search_text";

    @Override
    protected Fragment createFragment() {
        String searchText = (String) getIntent().getSerializableExtra(ARG_SEARCH_TEXT);
        return AnimeSearchFragment.newInstance(searchText);
    }
}
