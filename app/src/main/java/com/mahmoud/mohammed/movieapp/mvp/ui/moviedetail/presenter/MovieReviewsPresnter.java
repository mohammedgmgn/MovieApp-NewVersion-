package com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.presenter;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mahmoud.mohammed.movieapp.mvp.base.BasePresenter;
import com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel.ReviewResponse;
import com.mahmoud.mohammed.movieapp.mvp.helper.Constants;
import com.mahmoud.mohammed.movieapp.mvp.network.MoviesService;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.interfaces.MovieReviews;

/**
 * Created by mohammed on 11/3/2017.
 */

public class MovieReviewsPresnter extends BasePresenter<MovieReviews> {
    @Override
    public void attachView(MovieReviews view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadMovieReviews(Intent intent) {
        String movieID = intent.getExtras().getString("ID");
        Uri build = Uri.parse(Constants.BASE_URL).buildUpon().appendPath(movieID).appendPath(Constants.REVIEWS).appendQueryParameter(Constants.API_KEY_STRING, Constants.API_KEY).build();
        MoviesService.getResponse(ReviewResponse.class, build.toString(), new ValueCallback<Object>() {
            @Override
            public void onReceiveValue(Object object) {
                ReviewResponse reviewResponse=(ReviewResponse)object;
                getView().showReviews(reviewResponse.getReviews());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getView().showError(error.getMessage());

            }
        });


    }
}
