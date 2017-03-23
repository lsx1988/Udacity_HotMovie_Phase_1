package com.bignerdranch.android.hotmovie;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by shixunliu on 22/3/17.
 */

public class MovieDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_MOVIE = "movie_from_list";

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        return MovieDetailFragment.newInstance(movie);
    }
}
