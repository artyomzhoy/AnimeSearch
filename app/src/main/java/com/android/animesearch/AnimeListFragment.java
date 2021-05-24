package com.android.animesearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private AnimeAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.anime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private class AnimeHolder extends RecyclerView.ViewHolder {
        public AnimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_anime, parent,false));
        }
    }

    private class AnimeAdapter extends RecyclerView.Adapter<AnimeHolder> {
        private List<Anime> mAnimeList;

        public AnimeAdapter(List<Anime> animeList) {
            mAnimeList = animeList;
        }

        @Override
        public AnimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new AnimeHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(AnimeListFragment.AnimeHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mAnimeList.size();
        }
    }

    private void updateUI() {

    }
}
