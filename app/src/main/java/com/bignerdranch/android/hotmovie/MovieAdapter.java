package com.bignerdranch.android.hotmovie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shixunliu on 22/3/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private List<Movie> movieList;

    private Context mContext;

    public class  MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final ImageView mImageView;

        public MovieViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            mImageView = (ImageView) view.findViewById(R.id.movie_img);
        }

        @Override
        public void onClick(View view) {
            Movie movie = movieList.get(getLayoutPosition());
            Intent intent = MovieDetailActivity.newIntent(mContext, movie);
            mContext.startActivity(intent);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        int layoutIdForListItem = R.layout.single_movie_layout;
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        String basePath = "http://image.tmdb.org/t/p/w185/";
        String movieImg = movie.getMoviePoster();
        String imgPath = basePath + movieImg;

        Picasso.with(mContext).load(imgPath).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        if (movieList == null) {
            return 0;
        } else {
            return movieList.size();
        }
    }

    public void setMovieData(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
}
