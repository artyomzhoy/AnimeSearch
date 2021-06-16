package com.android.animesearch.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.animesearch.Anime;
import com.android.animesearch.Jikan;
import com.android.animesearch.data.AnimeRepository;
import com.android.animesearch.data.RemoteAnimeRepository;
import com.android.animesearch.domain.ApiSearchUseCase;
import com.android.animesearch.domain.LoadPopularAnimeUseCase;
import com.android.animesearch.R;
import com.android.animesearch.data.LocalAnimeRepository;
import com.android.animesearch.domain.SearchUseCase;

import java.util.ArrayList;
import java.util.List;

public class AnimeListFragment extends Fragment {

    private static final String ARG_SEARCH_TEXT = "search_text";


    public static AnimeListFragment newInstance(String searchText) {

        Bundle args = new Bundle();
        args.putString(ARG_SEARCH_TEXT, searchText);

        AnimeListFragment fragment = new AnimeListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private RecyclerView mAnimeRecyclerView;
    private AnimeAdapter mAdapter;
    private AnimeListViewModel vm;
    private List<Anime> mAnime = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new JikanItemsTask().execute();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        AnimeRepository repository = new LocalAnimeRepository();
//        LoadPopularAnimeUseCase load = new LoadPopularAnimeUseCase(repository);
//        SearchUseCase search = new SearchUseCase(repository);
//        vm = new AnimeListViewModel(load, search);

        AnimeRepository repository = new RemoteAnimeRepository();
        ApiSearchUseCase apiSearch = new ApiSearchUseCase(repository);
        vm = new AnimeListViewModel(apiSearch);

        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);
        mAnimeRecyclerView = (RecyclerView) view.findViewById(R.id.anime_recycler_view);
        mAnimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void setupAdapter() {
        if (isAdded()) {
            mAnimeRecyclerView.setAdapter(new AnimeAdapter(mAnime));
        }
    }

    private static class AnimeHolder extends RecyclerView.ViewHolder {

        private Anime mAnime;
        private TextView mAnimeTitle;
        private TextView mAnimeSubject;
        private TextView mAnimeScore;
        private TextView mAnimeDate;


        public AnimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_anime, parent,false));

            mAnimeTitle = (TextView) itemView.findViewById(R.id.anime_title);
            mAnimeSubject = (TextView) itemView.findViewById(R.id.anime_subject);
            mAnimeScore = (TextView) itemView.findViewById(R.id.anime_score);
            mAnimeDate = (TextView) itemView.findViewById(R.id.anime_start_date);
        }

        public void bind(Anime anime) {
            mAnime = anime;
            mAnimeTitle.setText(mAnime.getTitleName());
            mAnimeSubject.setText(mAnime.getTitleSubjectId());
            mAnimeScore.setText(mAnime.getTitleScore());
            mAnimeDate.setText(mAnime.getTitleStartDate());
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
            return new AnimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(AnimeListFragment.AnimeHolder holder, int position) {
            Anime anime = mAnimeList.get(position);
            holder.bind(anime);
        }

        @Override
        public int getItemCount() {
            return mAnimeList.size();
        }

        public void setAnimeList(List<Anime> anime) {
            mAnimeList = anime;
        }
    }

    private void updateUI() {
        List<Anime> anime = vm.getApiAnimeList();
        if (mAdapter == null) {
            mAdapter = new AnimeAdapter(anime);
//            mAnimeRecyclerView.setAdapter(mAdapter);
            mAnimeRecyclerView.setAdapter(new AnimeAdapter(mAnime));
        } else {
            mAdapter.setAnimeList(anime);
            mAdapter.notifyDataSetChanged();
        }

    }

    public String getSearchArg() {
        return getArguments().getString(ARG_SEARCH_TEXT);
    }

    private class JikanItemsTask extends AsyncTask<Void, Void, List<Anime>> {

        @Override
        protected List<Anime> doInBackground(Void... params) {
            return new Jikan().fetchItems(getSearchArg());
        }

        @Override
        protected void onPostExecute(List<Anime> items) {
            mAnime = items;
            setupAdapter();
        }
    }
}
