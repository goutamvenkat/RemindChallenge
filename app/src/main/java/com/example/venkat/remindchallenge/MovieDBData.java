package com.example.venkat.remindchallenge;


import android.os.StrictMode;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.util.List;

/**
 * Created by Venkat on 11/21/15.
 */
public class MovieDBData {
    private TmdbApi data;
    private String API_KEY = "090227d55c23bf26b56c93d74a7b3f1a";
    public MovieDBData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        data = new TmdbApi(API_KEY);
    }
    public List<MovieDb> getPopularMovies() {
        MovieResultsPage results = data.getMovies().getPopularMovieList("", 0);
        List<MovieDb> allMovies = results.getResults();
        return allMovies;
    }

    public List<TvSeries> getPopularTVShows() {
        TvResultsPage results = data.getTvSeries().getPopular("", 0);
        List<TvSeries> allTvShows = results.getResults();
        return allTvShows;
    }
}
