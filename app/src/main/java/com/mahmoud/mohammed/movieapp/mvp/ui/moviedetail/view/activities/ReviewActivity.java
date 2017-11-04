package com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mahmoud.mohammed.movieapp.R;
import com.mahmoud.mohammed.movieapp.mvp.base.BaseActivity;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.model.Review;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.presenter.MovieReviewsPresnter;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.interfaces.MovieReviews;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends BaseActivity implements MovieReviews {
    MovieReviewsPresnter presnter;
    TextView reviewTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        reviewTv = (TextView) findViewById(R.id.mytxt_review);
        presnter = new MovieReviewsPresnter();
        presnter.attachView(this);
        presnter.loadMovieReviews(getIntent());
        setTitle("Reviews");
        this.setFinishOnTouchOutside(true);

    }

    @Override
    public void setLoading() {

    }

    @Override
    public void setLoaded() {

    }

    @Override
    public void showReviews(List<Review> reviews) {
        //  reviewTv.setText(reviews);
        List<String> revi = new ArrayList<>();
        for (int i = 0; i < reviews.size(); i++) {

            revi.add("written by: " + reviews.get(i).getAuthor() + "\n" + reviews.get(i).getContent());
            Log.v("reviewsList", revi.get(i));
        }

        StringBuilder mybuilder = new StringBuilder();

        for (int j = 0; j < revi.size(); j++) {

            mybuilder.append(revi.get(j) + "\n\n--------------------------------------\n\n");
        }
        String res = String.valueOf(mybuilder);
        Log.v("reviewsResult", res);

        reviewTv.setText(res);

    }

    @Override
    public void showError(String message) {

    }
}

