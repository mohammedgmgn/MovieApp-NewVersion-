package com.mahmoud.mohammed.movieapp.mvp.base;

/**
 * Created by mohammed on 10/31/2017.
 */
public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
