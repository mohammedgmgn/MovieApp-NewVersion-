package com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mahmoud.mohammed.movieapp.R;
import com.mahmoud.mohammed.movieapp.mvp.adapters.TrailerAdapter;
import com.mahmoud.mohammed.movieapp.mvp.base.BaseActivity;
import com.mahmoud.mohammed.movieapp.mvp.helper.ImageHelper;
import com.mahmoud.mohammed.movieapp.mvp.ui.main.model.Movie;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.model.Trailer;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.presenter.MovieDetailPresenter;
import com.mahmoud.mohammed.movieapp.mvp.ui.moviedetail.view.interfaces.MovieDetailViews;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements MovieDetailViews {
    MovieDetailPresenter presenter;
    @BindView(R.id.toolbartest)
    Toolbar toolbar;
    @BindView(R.id.favor)
    FloatingActionButton FavoriteBtn;

    @BindView(R.id.collapsingToolbartest)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.cover)
    ImageView backdrop;
    @BindView(R.id.posterimage)
    ImageView poster;
    @BindView(R.id.ratings_background)
    ImageView ratingsBackground;
    @BindView(R.id.genre_background)
    ImageView genreBackground;
    @BindView(R.id.pop_background)
    ImageView popBackground;
    @BindView(R.id.lang_background)
    ImageView langBackground;
    @BindView(R.id.title1)
    TextView title;
    @BindView(R.id.tagline)
    TextView tagline;
    @BindView(R.id.review)
    Button review;
    @BindView(R.id.description)
    TextView overview;
    @BindView(R.id.date_status)
    TextView dateStatusView;
    @BindView(R.id.rate)
    TextView ratingView;
    @BindView(R.id.language)
    TextView languageView;
    @BindView(R.id.popularity)
    TextView popularityView;
    @BindView(R.id.vote_count)
    TextView voteCountView;
    @BindView(R.id.recyclerViewtrailer)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        presenter = new MovieDetailPresenter();
        initUi();
    }


    private void initUi() {
        setSupportActionBar(toolbar);
        presenter.attachView(this);
        presenter.loadMovieDetails(getIntent());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayout.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        popBackground.setColorFilter(Color.parseColor("#BE2F2F"), PorterDuff.Mode.MULTIPLY);
        ratingsBackground.setColorFilter(Color.parseColor("#BE2F2F"), PorterDuff.Mode.MULTIPLY);
        genreBackground.setColorFilter(Color.parseColor("#BE2F2F"), PorterDuff.Mode.MULTIPLY);
        langBackground.setColorFilter(Color.parseColor("#BE2F2F"), PorterDuff.Mode.MULTIPLY);
        presenter.loadMovieTrailers(getIntent());
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadMovieReviews(getIntent());

            }
        });
    }

    @Override
    public void setLoading() {

    }

    @Override
    public void setLoaded() {

    }

    @Override
    public void displayMovieDetail(Movie movie) {
        ImageHelper.setGlideImage(DetailActivity.this, movie.getBackdropPath(), backdrop);
        ImageHelper.setGlideImage(DetailActivity.this, movie.getPosterPath(), poster);
        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());
        languageView.setText(movie.getOriginalLanguage());
        voteCountView.setText(movie.getVoteCount() + " votes");
        popularityView.setText(movie.getPopularity().substring(0, 4));
        dateStatusView.setText(movie.getReleaseDate() + " (Released)");
        ratingView.setText((movie.getVoteAverage()));
        collapsingToolbar.setTitle(movie.getTitle());

    }

    @Override
    public void displayMovieReview(String movieId) {
        Intent i = new Intent(DetailActivity.this, ReviewActivity.class);
        i.putExtra("ID", movieId);
        startActivity(i);

    }

    @Override
    public void displayMovieTrailer(List<Trailer> trailers) {
        List<String> trailerInfo = new ArrayList();
        for (int i = 0; i < trailers.size(); i++) {
            trailerInfo.add(trailers.get(i).getKey() + ",," + trailers.get(i).getName()
                    + ",," + trailers.get(i).getSite() + ",," + trailers.get(i).getSize());

        }

        TrailerAdapter mAdapter = new TrailerAdapter(this, trailerInfo);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void showError(String message) {

    }
}
