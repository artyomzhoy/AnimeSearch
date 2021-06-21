package com.android.animesearch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.animesearch.Anime;
import com.android.animesearch.data.AnimeRepository;
import com.android.animesearch.data.RemoteAnimeRepository;
import com.android.animesearch.domain.ApiSearchUseCase;
import com.android.animesearch.R;
import com.android.animesearch.domain.LoadPopularAnimeUseCase;
import com.android.animesearch.domain.SearchUseCase;
import com.android.animesearch.ui.selectedAnime.AnimeActivity;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AnimeListFragment extends Fragment {

    private static final String ARG_SEARCH_TEXT = "search_text";
    private Executor executor = Executors.newCachedThreadPool();

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AnimeRepository repository = new RemoteAnimeRepository();
        LoadPopularAnimeUseCase load = new LoadPopularAnimeUseCase(repository);
        ApiSearchUseCase api = new ApiSearchUseCase(repository);
        SearchUseCase search = new SearchUseCase(repository);

        vm = new AnimeListViewModel(load, search, api);

        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);
        mAnimeRecyclerView = (RecyclerView) view.findViewById(R.id.anime_recycler_view);
        mAnimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private class AnimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Anime mAnime;
        private TextView mAnimeTitle;
        private TextView mAnimeSubject;
        private TextView mAnimeScore;
        private TextView mAnimeDate;
        private ImageView mAnimePicture;
        private ImageView mStar;

        public AnimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_anime, parent,false));

            mAnimeTitle = (TextView) itemView.findViewById(R.id.anime_title);
            mAnimeSubject = (TextView) itemView.findViewById(R.id.anime_subject);
            mAnimeScore = (TextView) itemView.findViewById(R.id.anime_score);
            mAnimeDate = (TextView) itemView.findViewById(R.id.anime_start_date);
            mAnimePicture = (ImageView) itemView.findViewById(R.id.anime_picture);
            mStar = (ImageView) itemView.findViewById(R.id.star);
        }

        public void bind(Anime anime) throws ParseException {

            final String OLD_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
            final String NEW_FORMAT = "MMMM d, yyyy";

            mAnime = anime;
            mAnimeTitle.setText(mAnime.getTitleName());
            mAnimeSubject.setText(mAnime.getTitleSubjectId());
            mAnimeScore.setText(mAnime.getTitleScore());
            Picasso.get().load(mAnime.getTitlePicture()).into(mAnimePicture);

            String oldDateString = mAnime.getTitleStartDate();
            String newDateString;

            SimpleDateFormat formatter = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);
            Date date = formatter.parse(oldDateString);
            formatter.applyPattern(NEW_FORMAT);
            newDateString = formatter.format(date);
            mAnimeDate.setText(newDateString);
        }

        @Override
        public void onClick(View view) {
            UUID animeId = mAnime.getId();
            Intent intent = AnimeActivity.newIntent(getActivity(), animeId);
            startActivity(intent);
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
            try {
                holder.bind(anime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List < Anime > anime = vm.getApiAnimeList(getSearchArg());
                updateList(anime);
            }
        };

        executor.execute(runnable);
    }

    private void updateList(List<Anime> list) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (mAdapter == null) {
                    mAdapter = new AnimeAdapter(list);
                    mAnimeRecyclerView.setAdapter(mAdapter);
                    mAnimeRecyclerView.setAdapter(new AnimeAdapter(list));
                } else {
                    mAdapter.setAnimeList(list);
                    mAdapter.notifyDataSetChanged();
                }
            }
        };

        Handler mainHandler = new Handler(requireContext().getMainLooper());
        mainHandler.post(runnable);
    }

    public String getSearchArg() {
        return getArguments().getString(ARG_SEARCH_TEXT);
    }
}
