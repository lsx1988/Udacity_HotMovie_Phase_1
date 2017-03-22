/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bignerdranch.android.hotmovie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class OpenMovieJsonUtils {

    public static List<Movie> getMovieInfoFromJson(String movieListJsonStr)
            throws JSONException {

        final String OWM_LIST = "results";

        final String OWM_POSTER = "poster_path";

        final String OWM_OVERVIEW = "overview";

        final String OWM_DATE = "release_date";

        final String OWM_TITLE = "title";

        final String OWM_VOTE = "vote_average";

        final String OWM_LANGUAGE = "original_language";

        List<Movie> movieList = new ArrayList<>();

        JSONObject JsonFromNet = new JSONObject(movieListJsonStr);

        JSONArray movieArray = JsonFromNet.getJSONArray(OWM_LIST);

        for (int i = 0; i < movieArray.length(); i++) {

            JSONObject movieJson = movieArray.getJSONObject(i);

            String poster_path = movieJson.getString(OWM_POSTER);

            String overview = movieJson.getString(OWM_OVERVIEW);

            String date = movieJson.getString(OWM_DATE);

            String title = movieJson.getString(OWM_TITLE);

            String vote = movieJson.getString(OWM_VOTE);

            String language = movieJson.getString(OWM_LANGUAGE);

            Movie movie = new Movie();

            movie.setMoviePoster(poster_path);
            movie.setMovieRate(vote);
            movie.setMovieSynopsis(overview);
            movie.setMovieTitle(title);
            movie.setMoviewReleaseData(date);
            movie.setMovieLanguage(language);

            movieList.add(movie);
        }

        return movieList;
    }
}