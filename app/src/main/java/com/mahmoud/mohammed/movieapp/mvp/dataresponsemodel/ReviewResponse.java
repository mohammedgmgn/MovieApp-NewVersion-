package com.mahmoud.mohammed.movieapp.mvp.dataresponsemodel;

import com.google.gson.annotations.SerializedName;
import com.mahmoud.mohammed.movieapp.mvp.models.Review;

import java.util.List;

/**
 * Created by mohammed on 11/3/2017.
 */

public class ReviewResponse {
    @SerializedName("id")
    private String id;
    @SerializedName("page")
    private String page;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("total_results")
    private int total_results;
    @SerializedName("results")
    private List<Review> reviews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
