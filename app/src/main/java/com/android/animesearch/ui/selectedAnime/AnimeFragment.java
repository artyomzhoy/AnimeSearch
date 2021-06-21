package com.android.animesearch.ui.selectedAnime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.animesearch.Anime;
import com.android.animesearch.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AnimeFragment extends Fragment {

    private static final String ARG_ANIME = "anime";

    private Anime mAnime;
    private TextView mAnimeTitle;
    private TextView mAnimeSubject;
    private TextView mAnimeScore;
    private TextView mAnimeDate;
    private ImageView mAnimePicture;
    private ImageView mStar;

    final String OLD_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
    final String NEW_FORMAT = "MMMM d, yyyy";

    public static AnimeFragment newInstance(Anime anime) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANIME, anime);

        AnimeFragment fragment = new AnimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mAnime = (Anime) getArguments().getSerializable(ARG_ANIME);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anime, container, false);

        mAnimePicture = (ImageView) view.findViewById(R.id.selected_anime_picture);
        Picasso.get().load(mAnime.getTitlePicture()).into(mAnimePicture);


        mAnimeTitle = (TextView) view.findViewById(R.id.selected_anime_title);
        mAnimeTitle.setText(mAnime.getTitleName());


        mStar = (ImageView) view.findViewById(R.id.selected_anime_star);


        mAnimeScore = (TextView) view.findViewById(R.id.selected_anime_score);
        mAnimeScore.setText(mAnime.getTitleScore());


        mAnimeDate = (TextView) view.findViewById(R.id.selected_anime_start_date);
        String oldDateString = mAnime.getTitleStartDate();
        String newDateString;

        SimpleDateFormat formatter = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(oldDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.applyPattern(NEW_FORMAT);
        newDateString = formatter.format(date);
        mAnimeDate.setText(newDateString);

        mAnimeSubject = (TextView) view.findViewById(R.id.selected_anime_subject);
        mAnimeSubject.setText(mAnime.getTitleSubjectId());


        return view;
    }


}
