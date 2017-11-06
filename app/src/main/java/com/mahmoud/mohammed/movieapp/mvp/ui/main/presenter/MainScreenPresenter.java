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
        MoviesService.getResponse(MovieResponse.class, Constants.BASE_URL + MoviesType + Constants.API_KEY_SUFFIX + Constants.API_KEY,
                new ValueCallback<Object>() {
                    @Override
                    public void onReceiveValue(Object object) {
                        getView().setLoaded();
                        MovieResponse movieResponse = (MovieResponse) object;
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
