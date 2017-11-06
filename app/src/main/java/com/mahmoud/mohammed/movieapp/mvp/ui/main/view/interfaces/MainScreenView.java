package com.mahmoud.mohammed.movieapp.mvp.ui.main.view.interfaces;

import com.mahmoud.mohammed.movieapp.mvp.base.BaseView;
import com.mahmoud.mohammed.movieapp.mvp.models.Movie;

import java.util.List;

/**
 * Created by mohammed on 10/31/2017.
 */
public interface MainScreenView extends BaseView {
    void showMovies(List<Movie> movies);

    void setLoadingError();
}
