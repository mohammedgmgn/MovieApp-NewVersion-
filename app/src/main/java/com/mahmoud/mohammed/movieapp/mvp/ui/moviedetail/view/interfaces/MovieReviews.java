package com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.interfaces;

import com.mahmoud.mohammed.movieapp.mvp.base.BaseView;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.model.Review;

import java.util.List;

/**
 * Created by mohammed on 11/3/2017.
 */

public interface MovieReviews extends BaseView {
    void showReviews(List<Review> reviews);
    void showError(String message);

}
