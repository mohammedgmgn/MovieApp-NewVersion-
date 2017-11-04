package com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel;

import com.google.gson.annotations.SerializedName;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.model.Trailer;

import java.util.List;

/**
 * Created by mohammed on 11/3/2017.
 */

public class TrailerResponse {
    @SerializedName("id")
    private String id;
    @SerializedName("results")
    private List<Trailer> trailers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

}
