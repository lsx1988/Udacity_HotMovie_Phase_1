package com.bignerdranch.android.hotmovie;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shixunliu on 22/3/17.
 */

public class Movie implements Parcelable{

    private String movieTitle;
    private String moviewReleaseData;
    private String moviePoster;
    private String movieRate;
    private String movieSynopsis;
    private String movieLanguage;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviewReleaseData() {
        return moviewReleaseData;
    }

    public void setMoviewReleaseData(String moviewReleaseData) {
        this.moviewReleaseData = moviewReleaseData;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(String movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(movieTitle);
        out.writeString(moviewReleaseData);
        out.writeString(moviePoster);
        out.writeString(movieRate);
        out.writeString(movieLanguage);
        out.writeString(movieSynopsis);
    }

    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(Parcel in) {
        movieTitle = in.readString();
        moviewReleaseData = in.readString();
        moviePoster = in.readString();
        movieRate = in.readString();
        movieLanguage = in.readString();
        movieSynopsis = in.readString();
    }

    public Movie() {
        super();
    }
}
