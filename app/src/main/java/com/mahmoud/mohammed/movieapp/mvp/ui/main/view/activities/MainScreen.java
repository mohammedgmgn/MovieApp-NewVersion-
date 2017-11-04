package com.mahmoud.mohammed.movieapp.mvp.ui.main.view.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mahmoud.mohammed.movieapp.R;
import com.mahmoud.mohammed.movieapp.mvp.adapters.MovieAdapter;
import com.mahmoud.mohammed.movieapp.mvp.adapters.OnMovieClickListener;
import com.mahmoud.mohammed.movieapp.mvp.base.BaseActivity;
import com.mahmoud.mohammed.movieapp.mvp.helper.Constants;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.model.Movie;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.presenter.MainScreenPresenter;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.view.interfaces.MainScreenView;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.activities.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainScreen extends BaseActivity implements MainScreenView, OnMovieClickListener {
    MainScreenPresenter mainScreenPresnter;
    MovieAdapter adapter;
    @BindView(R.id.movie_recycler_view_id)
    RecyclerView moviesRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.failed_to_load_TV)
    TextView failedToLoadTV;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mainScreenPresnter = new MainScreenPresenter();
        adapter = new MovieAdapter(new ArrayList<>(), this);
        initUI();
    }

    private void initUI() {
        adapter.setOnMovieClickListener(this);
        moviesRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        moviesRecyclerView.setAdapter(adapter);
        moviesRecyclerView.setHasFixedSize(true);
        mainScreenPresnter.attachView(this);
        mainScreenPresnter.loadPopularMovies();
    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.updateAdapter(movies);
    }

    @Override
    public void setLoadingError() {
        showViews(failedToLoadTV);

    }

    @Override
    public void setLoading() {
        showViews(progressBar);
    }

    @Override
    public void setLoaded() {
        hideViews(progressBar);

    }

    @Override
    public void onMovieClicked(Movie movie) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constants.MOVIE, movie);
        startActivity(intent);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.popular) {
            mainScreenPresnter.loadPopularMovies();

            return true;
        } else if (id == R.id.high) {
            mainScreenPresnter.loadTopRatedMovies();

            return true;

            //TODO issue netwirk request
        }
        return onOptionsItemSelected(item);

    }


}
