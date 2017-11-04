package com.mahmoud.mohammed.movieapp.mvp.ui.main.presenter;


import android.webkit.ValueCallback;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mahmoud.mohammed.movieapp.mvp.base.BasePresenter;
import com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel.MovieResponse;
import com.mahmoud.mohammed.movieapp.mvp.helper.Constants;
import com.mahmoud.mohammed.movieapp.mvp.network.MoviesService;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.view.interfaces.MainScreenView;

/**
 * Created by mohammed on 10/31/2017.
 */
public class MainScreenPresenter extends BasePresenter<MainScreenView> {


    @Override
    public void attachView(MainScreenView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadTopRatedMovies() {
        loadMovies(Constants.TOP_RATED);
    }


    public void loadPopularMovies() {
        loadMovies(Constants.POPULAR);

    }

    private void loadMovies(String MoviesType) {
        getView().setLoading();
        MoviesService.getMovieResponse(MoviesType, new ValueCallback<MovieResponse>() {
            @Override
            public void onReceiveValue(MovieResponse movieResponse) {
                getView().setLoaded();
                getView().showMovies(movieResponse.getMovies());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getView().setLoadingError();
            }
        });

    }
}
