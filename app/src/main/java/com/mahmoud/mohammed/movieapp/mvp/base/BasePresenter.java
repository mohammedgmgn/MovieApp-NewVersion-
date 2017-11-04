package com.mahmoud.mohammed.movieapp.mvp.base;

/**
 * Created by mohammed on 10/31/2017.
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public V getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

}