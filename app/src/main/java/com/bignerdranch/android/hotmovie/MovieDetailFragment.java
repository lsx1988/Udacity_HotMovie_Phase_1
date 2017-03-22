package com.bignerdranch.android.hotmovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by shixunliu on 22/3/17.
 */

public class MovieDetailFragment extends Fragment {

    private static final String ARGS_MOIVE = "movie_from_list";

    private Movie mMovie = null;

    private TextView mTitle = null
            , mYear = null
            , mVote = null
            , mAbstract = null
            , mLanguage = null;

    private ImageView mImageView = null;

    public static MovieDetailFragment newInstance(Movie movie) {
        Bundle args = new Bundle();
        args.putSerializable(ARGS_MOIVE, movie);

        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = (Movie) getArguments().getSerializable(ARGS_MOIVE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_detail_layout, container, false);
        mTitle = (TextView) view.findViewById(R.id.movie_title);
        mYear = (TextView) view.findViewById(R.id.movie_year);
        mVote = (TextView) view.findViewById(R.id.movie_vote);
        mAbstract = (TextView) view.findViewById(R.id.movie_abstract);
        mLanguage = (TextView) view.findViewById(R.id.movie_language);
        mImageView = (ImageView) view.findViewById(R.id.movie_pic);

        mTitle.setText(mMovie.getMovieTitle());
        mVote.setText(mMovie.getMovieRate() + " / 10");
        mAbstract.setText(mMovie.getMovieSynopsis());
        mYear.setText(mMovie.getMoviewReleaseData());
        mLanguage.setText("LANGUAGE: " + mMovie.getMovieLanguage());

        String basePath = "http://image.tmdb.org/t/p/w185/";
        String movieImg = mMovie.getMoviePoster();
        String imgPath = basePath + movieImg;

        Picasso.with(getContext()).load(imgPath).into(mImageView);

        return view;
    }
}
