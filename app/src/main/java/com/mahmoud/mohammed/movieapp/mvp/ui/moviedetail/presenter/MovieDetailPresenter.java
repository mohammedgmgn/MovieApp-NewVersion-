package com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.presenter;

import android.content.Intent;
import android.webkit.ValueCallback;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mahmoud.mohammed.movieapp.mvp.base.BasePresenter;
import com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel.TrailerResponse;
import com.mahmoud.mohammed.movieapp.mvp.helper.Constants;
import com.mahmoud.mohammed.movieapp.mvp.network.MoviesService;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.model.Movie;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.interfaces.MovieDetailViews;

/**
 * Created by mohammed on 11/1/2017.
 */
public class MovieDetailPresenter extends BasePresenter<MovieDetailViews> {

    @Override
    public void attachView(MovieDetailViews view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadMovieDetails(Intent intent) {
        Movie movie = intent.getExtras().getParcelable(Constants.MOVIE);
        getView().displayMovieDetail(movie);

    }

    public void loadMovieTrailers(Intent intent) {
        Movie movie = intent.getExtras().getParcelable(Constants.MOVIE);

        MoviesService.getTrailersResponse(movie.getId(), new ValueCallback<TrailerResponse>() {
            @Override
            public void onReceiveValue(TrailerResponse trailerResponse) {
                getView().displayMovieTrailer(trailerResponse.getTrailers());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               getView().showError(error.getMessage());
            }
        });

    }

    public void loadMovieReviews(Intent intent) {
        Movie movie = intent.getExtras().getParcelable(Constants.MOVIE);
        getView().displayMovieReview(movie.getId());
    }

}
