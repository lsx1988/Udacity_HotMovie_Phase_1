package com.bignerdranch.android.hotmovie;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by shixunliu on 22/3/17.
 */

public class Movie implements Serializable{

    private UUID mId;
    private String movieTitle;
    private String moviewReleaseData;
    private String moviePoster;
    private String movieRate;
    private String movieSynopsis;
    private String movieLanguage;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

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
}
