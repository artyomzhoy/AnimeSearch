package com.android.animesearch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.android.animesearch.R;

public class AnimeSearchFragment extends Fragment {

    private Button mSearchButton;
    private EditText mSearchView;

    public static AnimeSearchFragment newInstance () {
        return new AnimeSearchFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime_search, container, false);

    mSearchButton = (Button) view.findViewById(R.id.button_search);
    mSearchButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), AnimeListActivity.class);
            startActivity(intent);
        }
    });

    mSearchView = (EditText) view.findViewById(R.id.search_view);
    mSearchView.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

    return view;
    }
}
