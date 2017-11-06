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
import com.mahmoud.mohammed.movieapp.mvp.volleysingletone.ApplicationController;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by mohammed on 11/2/2017.
 */
public class MoviesService {
         public static void getResponse(Class<?> obClass,String URL, ValueCallback<Object> callback, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                callback.onReceiveValue(gson.fromJson(String.valueOf(response), obClass));
            }
        }, errorListener);
        ApplicationController.getInstance().addToRequestQueue(request);
    }


}
