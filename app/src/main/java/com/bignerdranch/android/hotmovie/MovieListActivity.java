package com.bignerdranch.android.hotmovie;

import android.support.v4.app.Fragment;

/**
 * Created by shixunliu on 22/3/17.
 */

public class MovieListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MovieListFragment();
    }
}
