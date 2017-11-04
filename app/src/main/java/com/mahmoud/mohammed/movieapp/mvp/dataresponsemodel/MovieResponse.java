package com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel;

import com.google.gson.annotations.SerializedName;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.model.Movie;

import java.util.List;

/**
 * Created by mohammed on 11/1/2017.
 */
public class MovieResponse {
    @SerializedName("results")
    private List<Movie> movies;

    @SerializedName("page")
    private String page;

    @SerializedName("total_pages")
    private String totalPages;

    @SerializedName("total_results")
    private String totalResults;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}

