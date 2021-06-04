package com.android.animesearch.ui;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.animesearch.SingleFragmentActivity;

public class AnimeListActivity extends SingleFragmentActivity {

    private static final String ARG_SEARCH_TEXT = "search_text";


    public static Intent newIntent(Context packageContext, String searchText) {
        Intent intent = new Intent(packageContext, AnimeListActivity.class);
        intent.putExtra(ARG_SEARCH_TEXT, searchText);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String searchText = getIntent().getStringExtra(ARG_SEARCH_TEXT);
        return AnimeListFragment.newInstance(searchText);
    }
}