package com.android.animesearch.ui;

import androidx.fragment.app.Fragment;

import com.android.animesearch.SingleFragmentActivity;

public class AnimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new AnimeListFragment();
    }
}