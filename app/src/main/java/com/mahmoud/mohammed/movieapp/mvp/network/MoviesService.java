package com.mahmoud.mohammed.movieapp.mvp.network;

import android.net.Uri;
import android.webkit.ValueCallback;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel.MovieResponse;
import com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel.ReviewResponse;
import com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel.TrailerResponse;
import com.mahmoud.mohammed.movieapp.mvp.helper.Constants;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.model.Movie;
import com.mahmoud.mohammed.movieapp.mvp.volleysingletone.ApplicationController;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by mohammed on 11/2/2017.
 */
public class MoviesService {

    public static void getMovieResponse(String MoviesType, ValueCallback<MovieResponse> callback, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Constants.BASE_URL + MoviesType + Constants.API_KEY_SUFFIX + Constants.API_KEY, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                MovieResponse mainResponse = gson.fromJson(String.valueOf(response), MovieResponse.class);
                List<Movie> list = mainResponse.getMovies();
                callback.onReceiveValue(mainResponse);
            }
        }, errorListener);
        ApplicationController.getInstance().addToRequestQueue(request);
    }

    public static void getTrailersResponse(String id, ValueCallback<TrailerResponse> callback, Response.ErrorListener errorListener) {
        String requestUrl = Constants.BASE_URL + id + Constants.VIDEOS + Constants.API_KEY_SUFFIX + Constants.API_KEY;

        JsonObjectRequest mTrailerRequest = new JsonObjectRequest(requestUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                TrailerResponse trailerResponse = gson.fromJson(String.valueOf(response), TrailerResponse.class);
                callback.onReceiveValue(trailerResponse);


            }
        }, errorListener);
        ApplicationController.getInstance().addToRequestQueue(mTrailerRequest);
    }

    public static void getReviewResponse(String id, ValueCallback<ReviewResponse> callback, Response.ErrorListener errorListener) {
        Uri build = Uri.parse(Constants.BASE_URL).buildUpon()
                .appendPath(id).appendPath(Constants.REVIEWS).appendQueryParameter(Constants.API_KEY_STRING, Constants.API_KEY).build();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, build.toString(), (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                ReviewResponse reviewResponse = gson.fromJson(String.valueOf(response), ReviewResponse.class);
                callback.onReceiveValue(reviewResponse);

            }
        }, errorListener);
        ApplicationController.getInstance().addToRequestQueue(request);

    }


}
