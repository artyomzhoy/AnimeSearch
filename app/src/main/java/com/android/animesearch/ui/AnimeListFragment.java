package com.android.animesearch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.animesearch.Anime;
import com.android.animesearch.domain.LoadPopularAnimeUseCase;
import com.android.animesearch.R;
import com.android.animesearch.data.LocalAnimeRepository;

import java.util.List;

public class AnimeListFragment extends Fragment {

    public static AnimeListFragment newInstance() {
        return new AnimeListFragment();
    }

    private RecyclerView mAnimeRecyclerView;
    private AnimeAdapter mAdapter;

    private final AnimeListViewModel vm = new AnimeListViewModel(new LoadPopularAnimeUseCase(new LocalAnimeRepository()));

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);
        mAnimeRecyclerView = (RecyclerView) view.findViewById(R.id.anime_recycler_view);
        mAnimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private static class AnimeHolder extends RecyclerView.ViewHolder {

        private Anime mAnime;
        private TextView mAnimeTitle;
        private TextView mAnimeSubject;
        private TextView mAnimeRating;
        private TextView mAnimeDate;


        public AnimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_anime, parent,false));

            mAnimeTitle = (TextView) itemView.findViewById(R.id.anime_title);
            mAnimeSubject = (TextView) itemView.findViewById(R.id.anime_subject);
            mAnimeRating = (TextView) itemView.findViewById(R.id.anime_rating);
            mAnimeDate = (TextView) itemView.findViewById(R.id.anime_start_date);
        }

        public void bind(Anime anime) {
            mAnime = anime;
            mAnimeTitle.setText(mAnime.getTitleNameID());
            mAnimeSubject.setText(mAnime.getTitleSubjectId());
            mAnimeRating.setText((int) mAnime.getTitleRating());
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
        List<Anime> anime = vm.getAnimeList();
        if (mAdapter == null) {
            mAdapter = new AnimeAdapter(anime);
            mAnimeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setAnimeList(anime);
            mAdapter.notifyDataSetChanged();
        }

    }
    /*public <Anime> List<Anime> convertArrToList (Anime[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    } */
}
