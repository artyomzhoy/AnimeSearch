package com.android.animesearch;

import androidx.fragment.app.Fragment;

public class AnimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new AnimeListFragment();
    }
}