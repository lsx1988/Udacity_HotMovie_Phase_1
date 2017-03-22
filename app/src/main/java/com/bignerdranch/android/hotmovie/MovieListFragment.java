package com.bignerdranch.android.hotmovie;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.net.URL;
import java.util.List;

/**
 * Created by shixunliu on 22/3/17.
 */

public class MovieListFragment extends Fragment {

    private RecyclerView mRecyclerView = null;

    private MovieAdapter mMovieAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list_layout, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_movie_list);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        mMovieAdapter = new MovieAdapter();

        mRecyclerView.setAdapter(mMovieAdapter);

        new FetchMovieTask().execute("http://api.themoviedb.org/3/movie/popular");

        return view;
    }

    public class FetchMovieTask extends AsyncTask<String, Void, List<Movie>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Movie> doInBackground(String... params) {

            URL movieRequestUrl = NetWorkUtils.buildUrl(params[0]);

            try {
                String jsonMovieResponse = NetWorkUtils
                        .getResponseFromHttpUrl(movieRequestUrl);

                Log.d("background", jsonMovieResponse);

                List<Movie> movieList = OpenMovieJsonUtils
                        .getMovieInfoFromJson(jsonMovieResponse);

                return movieList;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Movie> movieList) {
            if (movieList != null) {
                mMovieAdapter.setMovieData(movieList);
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_popular:
                new FetchMovieTask().execute("http://api.themoviedb.org/3/movie/popular");
                return true;
            case R.id.sort_by_vote:
                new FetchMovieTask().execute("http://api.themoviedb.org/3/movie/top_rated");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
