package com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.interfaces;

import com.mahmoud.mohammed.movieapp.mvp.base.BaseView;
import com.mahmoud.mohammed.movieapp.mvp.models.Movie;
import com.mahmoud.mohammed.movieapp.mvp.models.Trailer;

import java.util.List;

/**
 * Created by mohammed on 11/1/2017.
 */
public interface MovieDetailViews extends BaseView {

    void displayMovieDetail(Movie movie);

    void displayMovieReview(String movieId);

    void displayMovieTrailer(List<Trailer> trailers);

    void showError(String message);

}
